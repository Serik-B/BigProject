package BigProject.I;


import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private ArrayList<Aircrafts> aircrafts;
    private ArrayList<Flights>flights;
    private ArrayList<Tickets>tickets;
    private Aircrafts aircraft;
    private Flights flight;

    public PackageData() {
    }

    public PackageData(String operationType, ArrayList<Aircrafts> aircrafts, Aircrafts aircraft) {
        this.operationType = operationType;
        this.aircrafts = aircrafts;
        this.aircraft = aircraft;
    }



    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    public String getOperationType() {
        return operationType;
    }
    public void setAircrafts(ArrayList<Aircrafts> aircrafts) {
        this.aircrafts = aircrafts;
    }
    public ArrayList<Aircrafts> getAircrafts() {
        return aircrafts;
    }
    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }
    public Aircrafts getAircraft() {
        return aircraft;
    }
    public void addAircraft(Aircrafts aircraft) {
        aircrafts.add(aircraft);
    }




}