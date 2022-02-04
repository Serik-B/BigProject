package BigProject.I.City;


import BigProject.I.Aircrafts;
import BigProject.I.Cities;
import BigProject.I.Flights;
import BigProject.I.Tickets;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private ArrayList<Cities> cities;
    private Cities city;
    public PackageData() {
    }

    public PackageData(String operationType,ArrayList<Cities> cities, Cities city) {
        this.operationType = operationType;
        this.cities = cities;
        this.city = city;
    }
    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setCities(ArrayList<Cities>cities){this.cities=cities;}
    public ArrayList<Cities>getCities(){return cities;}
    public void setCity(Cities city){this.city=city;}
    public Cities getCity(){return city;}
}
