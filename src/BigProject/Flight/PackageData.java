package BigProject.I.Flight;

import BigProject.I.Cities;
import BigProject.I.Flights;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private ArrayList<Flights> flights;
    private Flights flight;
    public PackageData() {
    }

    public PackageData(String operationType,ArrayList<Flights> flights, Flights flight) {
        this.operationType = operationType;
        this.flights = flights;
        this.flight = flight;
    }
    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setFlights (ArrayList<Flights>flights){this.flights=flights;}
    public ArrayList<Flights>getFlights(){return flights;}
    public void setFlight(Flights flight){this.flight=flight;}
    public Flights getFlight(){return flight;}
}


