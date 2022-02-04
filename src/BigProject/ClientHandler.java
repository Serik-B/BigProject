package BigProject.I;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private Socket socket;
    private int id;
    private DBManager db;
    public ClientHandler(Socket socket, int id, DBManager db) {
        this.socket = socket;
        this.id = id;
        this.db=db;
    }

    public void run(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data = null;
            BigProject.I.City.PackageData dataC=null;

            while((data = (PackageData) inputStream.readObject()).getOperationType()!=null
                    &&(dataC=(BigProject.I.City.PackageData) inputStream.readObject()).getOperationType()!=null) {
                PackageData response = null;
                BigProject.I.City.PackageData responseC=null;

                if (data.getOperationType().equals("ADD_AIRCRAFTS")) {
                    db.addAircraft(data.getAircraft());
                    System.out.println("Aircraft "+id+" has added aircraft: name:"+data.getAircraft().getName()+"; model:"
                            +data.getAircraft().getModel()+"; business_class_capacity:"+data.getAircraft().getBusiness_class_capacity()
                    +"; econom_class_capacity:"+data.getAircraft().getEconom_class_capacity());
                    response=new PackageData("AIRCRAFT_ADDED", null, data.getAircraft());
                    outputStream.writeObject(response);
                } else if (data.getOperationType().equals("LIST_AIRCRAFTS")) {
                    System.out.println("Aircraft "+id+" has requested "+data.getOperationType());
                    ArrayList<Aircrafts> aircrafts = db.getAllAircrafts();
                    response = new PackageData("LIST_AIRCRAFTS_SEND", db.getAllAircrafts(), null);
                    outputStream.writeObject(response);
                }else if(data.getOperationType().equals("UPDATE_AIRCRAFTS")){
                    db.updateAircraft(data.getAircraft());
                    System.out.println("Aircraft "+data.getAircraft().getId()+" has updated aircraft: name:"+data.getAircraft().getName()+"; model:"
                            +data.getAircraft().getModel()+"; business_class_capacity:"+data.getAircraft().getBusiness_class_capacity()
                            +"; econom_class_capacity:"+data.getAircraft().getEconom_class_capacity());
                    response=new PackageData("AIRCRAFTS_UPDATED", null, data.getAircraft());
                    outputStream.writeObject(response);

                }
                else if(data.getOperationType().equals("DELETE_AIRCRAFTS")) {
                    db.deleteAircraft(data.getAircraft().getId());
                    System.out.println("Aircraft "+id+" has deleted" );
                    response=new PackageData("AIRCRAFTS_DELETED", null, data.getAircraft());
                    outputStream.writeObject(response);
                }


                else if (dataC.getOperationType().equals("ADD_CITIES")) {
                    db.addCity(dataC.getCity());
                    System.out.println("City " + id + " has added city: name:" + dataC.getCity().getName() + "; country:"
                            + dataC.getCity().getCountry() + "; short name:" + dataC.getCity().getShort_name());
                    responseC = new BigProject.I.City.PackageData("CITY_ADDED", null, dataC.getCity());
                    outputStream.writeObject(responseC);
                } else if (dataC.getOperationType().equals("LIST_CITIES")) {
                    System.out.println("Cities " + id + " has requested " + dataC.getOperationType());
                    ArrayList<Cities> cities = db.getAllCities();
                    responseC = new BigProject.I.City.PackageData("LIST_CITIES_SEND", db.getAllCities(), null);
                    outputStream.writeObject(responseC);
                } else if (dataC.getOperationType().equals("UPDATE_CITIES")) {
                    db.updateCity(dataC.getCity());
                    System.out.println("City " + dataC.getCity().getId() + " has updated city: name:" + dataC.getCity().getName() + "; country:"
                            + dataC.getCity().getCountry() + "; short name:" + dataC.getCity().getShort_name());
                    responseC = new BigProject.I.City.PackageData("CITIES_UPDATED", null, dataC.getCity());
                    outputStream.writeObject(responseC);

                } else if (dataC.getOperationType().equals("DELETE_CITIES")) {
                    db.deleteCity(dataC.getCity().getId());
                    System.out.println("City " + id + " has deleted");
                    responseC = new BigProject.I.City.PackageData("CITIES_DELETED", null, dataC.getCity());
                    outputStream.writeObject(responseC);
                }

                else {
                    System.out.println("Data is empty");
                }data=null;
            }



        }catch (Exception e){
            // e.printStackTrace();
            System.out.println("Client "+id+" has disconnected\n"+"THE SERVER KEEPS LISTENING");
        }

    }
}

