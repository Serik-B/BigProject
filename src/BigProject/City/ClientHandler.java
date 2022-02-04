package BigProject.I.City;
import BigProject.I.Cities;
import BigProject.I.DBManager;

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
            BigProject.I.City.PackageData dataC = null;

            while((dataC = (BigProject.I.City.PackageData) inputStream.readObject()).getOperationType()!=null) {
                BigProject.I.City.PackageData response = null;

                if (dataC.getOperationType().equals("ADD_CITIES")) {
                    db.addCity(dataC.getCity());
                    System.out.println("City " + id + " has added city: name:" + dataC.getCity().getName() + "; country:"
                            + dataC.getCity().getCountry() + "; short name:" + dataC.getCity().getShort_name());
                    response = new BigProject.I.City.PackageData("CITY_ADDED", null, dataC.getCity());
                    outputStream.writeObject(response);
                } else if (dataC.getOperationType().equals("LIST_CITIES")) {
                    System.out.println("Cities " + id + " has requested " + dataC.getOperationType());
                    ArrayList<Cities> cities = db.getAllCities();
                    response = new BigProject.I.City.PackageData("LIST_CITIES_SEND", db.getAllCities(), null);
                    outputStream.writeObject(response);
                } else if (dataC.getOperationType().equals("UPDATE_CITIES")) {
                    db.updateCity(dataC.getCity());
                    System.out.println("City " + dataC.getCity().getId() + " has updated city: name:" + dataC.getCity().getName() + "; country:"
                            + dataC.getCity().getCountry() + "; short name:" + dataC.getCity().getShort_name());
                    response = new BigProject.I.City.PackageData("CITIES_UPDATED", null, dataC.getCity());
                    outputStream.writeObject(response);

                } else if (dataC.getOperationType().equals("DELETE_CITIES")) {
                    db.deleteCity(dataC.getCity().getId());
                    System.out.println("City " + id + " has deleted");
                    response = new BigProject.I.City.PackageData("CITIES_DELETED", null, dataC.getCity());
                    outputStream.writeObject(response);
                } else {
                    System.out.println("Data is empty");
                }
                dataC = null;

            }

        }catch (Exception e){
            // e.printStackTrace();
            System.out.println("Client "+id+" has disconnected\n"+"THE SERVER KEEPS LISTENING");
        }
    }
}

