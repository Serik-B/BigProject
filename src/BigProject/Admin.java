package BigProject.I;



import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Admin {
    public static void main(String[] args) {
      MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        try {
            Socket socket = new Socket("localhost", 5222);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData pd  = null;
            BigProject.I.City.PackageData pdc=null;
            while (true) {
                System.out.println("Waiting request");
                if ((pd = mainFrame.getMessage()).getOperationType() != null) {
                    System.out.println("Request: " + pd.getOperationType());
                    outputStream.writeObject(pd);
                    pd = (PackageData) inputStream.readObject();
                    mainFrame.setMessage(pd);
                    if (pd != null) {
                        if (pd.getOperationType().equals("AIRCRAFT_ADDED")) {
                            System.out.println("Response: " + pd.getOperationType());
                            mainFrame.setMessage(new PackageData());
                        } else if (pd.getOperationType().equals("LIST_AIRCRAFT_SEND")) {
                            System.out.println("Response: " + pd.getOperationType());
                            ArrayList<Aircrafts> aircrafts = pd.getAircrafts();
                            mainFrame.getAircraftsList().generateTable(aircrafts);
                            mainFrame.setMessage(new PackageData());
                            pd = null;
                        } else if (pd.getOperationType().equals("AIRCRAFTS_UPDATED")) {
                            System.out.println("Response: " + pd.getOperationType());
                            mainFrame.setMessage(new PackageData());
                        } else if (pd.getOperationType().equals("AIRCRAFTS_DELETED")) {
                            System.out.println("Response: " + pd.getOperationType());
                            mainFrame.setMessage(new PackageData());
                        }
                    }
                    pd = null;
                } else if ((pdc = mainFrame.getMessageC()).getOperationType() != null) {
                    System.out.println("Request: " + pdc.getOperationType());
                    outputStream.writeObject(pdc);
                    pdc = (BigProject.I.City.PackageData) inputStream.readObject();
                    mainFrame.setMessageC(pdc);
                    if(pdc!=null){
                        if(pdc.getOperationType().equals("CITY_ADDED")){
                            System.out.println("Response: "+pdc.getOperationType());
                            mainFrame.setMessageC(new BigProject.I.City.PackageData());
                        }else if(pdc.getOperationType().equals("LIST_CITY_SEND")){
                            System.out.println("Response: "+pdc.getOperationType());
                            ArrayList<Cities> cities=pdc.getCities();
                            mainFrame.getCitiesList().generateTable(cities);
                            mainFrame.setMessageC(new BigProject.I.City.PackageData());
                            pd=null;
                        }else if(pdc.getOperationType().equals("CITIES_UPDATED")){
                            System.out.println("Response: "+pdc.getOperationType());
                            mainFrame.setMessageC(new BigProject.I.City.PackageData());
                        }else if(pdc.getOperationType().equals("CITIES_DELETED")){
                            System.out.println("Response: "+pdc.getOperationType());
                            mainFrame.setMessageC(new BigProject.I.City.PackageData());
                        }
                    }
                    pd=null;

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    }

