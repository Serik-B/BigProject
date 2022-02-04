package BigProject.I;

import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private AdminMainMenu adminMainMenu;
    private AircraftsPage  aircraftsPage;
    private CitiesPage  citiesPage;
    private FlightsPage flightsPage;
    public static int aircraftNumber=0;


    public static DBManager getDb() {
        return db;
    }

    private static DBManager db;
    private AircraftsList aircraftsList;
    private AircraftsCreat aircraftsCreat;
    private AircraftsUpdate aircraftsUpdate;
    private AircraftsDelete aircraftsDelete;

    private CitiesList citiesList;
    private CitiesCreat citiesCreat;
    private CitiesUpdate citiesUpdate;
    private CitiesDelete citiesDelete;

    private FlightsList flightsList;
    private FlightsCreat flightsCreat;
    private FlightsUpdate flightsUpdate;
    private FlightsDelete flightsDelete;

    private PackageData pd = new PackageData();
    private BigProject.I.City.PackageData pdc=new BigProject.I.City.PackageData();
    private BigProject.I.Flight.PackageData pdf=new BigProject.I.Flight.PackageData();
    private ArrayList<Aircrafts>aircrafts=new ArrayList<>();
    private ArrayList<Flights>flights=new ArrayList<>();
    private ArrayList<Cities>cities=new ArrayList<>();
    private ArrayList<Tickets>tickets=new ArrayList<>();
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("STUDENTS APPLICATION");
        setSize(500, 500);
        setLayout(null);
        adminMainMenu = new AdminMainMenu(this);
        adminMainMenu.setVisible(true);
        add(adminMainMenu);

        aircraftsPage = new AircraftsPage(this);
        aircraftsPage.setVisible(false);
        add(aircraftsPage);

        citiesPage = new CitiesPage(this);
        citiesPage.setVisible(false);
        add(citiesPage);

        flightsPage = new FlightsPage(this);
        flightsPage.setVisible(false);
        add(flightsPage);

        aircraftsList = new AircraftsList(this);
        aircraftsList.setVisible(false);
        add(aircraftsList);
        aircraftsCreat = new AircraftsCreat(this);
        aircraftsCreat.setVisible(false);
        add(aircraftsCreat);
        aircraftsUpdate = new AircraftsUpdate(this);
        aircraftsUpdate.setVisible(false);
        add(aircraftsUpdate);
        aircraftsDelete = new AircraftsDelete(this);
        aircraftsDelete.setVisible(false);
        add(aircraftsDelete);

        citiesList=new CitiesList(this);
        citiesList.setVisible(false);
        add(citiesList);
        citiesCreat=new CitiesCreat(this);
        citiesCreat.setVisible(false);
        add(citiesCreat);
        citiesUpdate=new CitiesUpdate(this);
        citiesUpdate.setVisible(false);
        add(citiesUpdate);
        citiesDelete=new CitiesDelete(this);
        citiesDelete.setVisible(false);
        add(citiesDelete);

        flightsList=new FlightsList(this);
        flightsList.setVisible(false);
        add(flightsList);
        flightsCreat=new FlightsCreat(this);
        flightsCreat.setVisible(false);
        add(flightsCreat);
        flightsUpdate=new FlightsUpdate(this);
        flightsUpdate.setVisible(false);
        add(flightsUpdate);
        flightsDelete=new FlightsDelete(this);
        flightsDelete.setVisible(false);
        add(flightsDelete);


    }

    public AdminMainMenu getAdminMainMenu() {
        return adminMainMenu;
    }

    public AircraftsPage getAircraftsPage() {
        return aircraftsPage;
    }

    public CitiesPage getCitiesPage() {
        return citiesPage;
    }

    public FlightsPage getFlightsPage() {
        return flightsPage;
    }

    public ArrayList<Flights> getFlights() {

        return (flights);
    }

    public AircraftsList getAircraftsList(){return aircraftsList;}

    public AircraftsCreat getAircraftsCreat() {
        return aircraftsCreat;
    }
    public AircraftsUpdate getAircraftsUpdate() {
        return aircraftsUpdate;
    }
    public AircraftsDelete getAircraftsDelete() {
        return aircraftsDelete;
    }

    public CitiesList getCitiesList() {
        return citiesList;
    }

    public CitiesCreat getCitiesCreat() {
        return citiesCreat;
    }

    public CitiesUpdate getCitiesUpdate() {
        return citiesUpdate;
    }

    public CitiesDelete getCitiesDelete() {
        return citiesDelete;
    }

    public FlightsList getFlightsList() {
        return flightsList;
    }

    public FlightsCreat getFlightsCreat() {
        return flightsCreat;
    }

    public FlightsUpdate getFlightsUpdate() {
        return flightsUpdate;
    }

    public FlightsDelete getFlightsDelete() {
        return flightsDelete;
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = flights;
    }

    public void setMessage(PackageData pd) {
        this.pd = pd;
    }

    public PackageData getMessage() {
        return pd;
    }

    public void setMessageC(BigProject.I.City.PackageData pdc) {
        this.pdc = pdc;
    }

    public BigProject.I.City.PackageData getMessageC() {
        return pdc;
    }

    public void setMessageF(BigProject.I.Flight.PackageData pdf) {
        this.pdf = pdf;
    }

    public BigProject.I.Flight.PackageData getMessageF() {
        return pdf;
    }
}
