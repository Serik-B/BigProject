package BigProject.I;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/airport?useUnicode=true&serverTimezone=UTC", "root", ""
            );
            System.out.println("CONNECTED TO DB");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Aircrafts> getAllAircrafts() {

        ArrayList<Aircrafts> aircrafts = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int business_class_capacity = rs.getInt("business_class_capacity");
                int econom_class_capacity=rs.getInt("econom_class_capacity");
                aircrafts.add(new Aircrafts(id, name, model, business_class_capacity,econom_class_capacity));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aircrafts;
    }

    public void addAircraft(Aircrafts aircraft) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(id, name, model, business_class_capacity,econom_class_capacity) values(NULL,?,?,?,?)");

            st.setString(1, aircraft.getName());
            st.setString(2, aircraft.getModel());
            st.setInt(3, aircraft.getBusiness_class_capacity());
            st.setInt(4, aircraft.getEconom_class_capacity());


            st.executeUpdate();

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteAircraft(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("delete from aircrafts where id = ?");

            st.setLong(1, id);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateAircraft(Aircrafts aircraft){
            try{
                 PreparedStatement st = connection.prepareStatement("update aircrafts set  name=?, model=?, business_class_capacity=?,econom_class_capacity=? where id = ? ");
                st.setString(1, aircraft.getName());
                st.setString(2, aircraft.getModel());
                st.setInt(3, aircraft.getBusiness_class_capacity());
                st.setInt(4, aircraft.getEconom_class_capacity());
                st.setLong(5, aircraft.getId());


                st.executeUpdate();

            }catch (Exception e){
                e.printStackTrace();
            }


    }

    public ArrayList<Cities> getAllCities() {

        ArrayList<Cities> cities = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String short_name = rs.getString("short_name");

                cities.add(new Cities(id, name, country, short_name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }
    public void addCity(Cities city) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(id, name, country, short_name) values(NULL,?,?,?)");

            st.setString(1, city.getName());
            st.setString(2, city.getCountry());
            st.setString(3, city.getShort_name());


            st.executeUpdate();

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateCity(Cities city){
        try{
            PreparedStatement st = connection.prepareStatement("update cities set  name=?, country=?, short_name=? where id=?");
            st.setLong(1, city.getId());
            st.setString(2, city.getName());
            st.setString(3, city.getCountry());
            st.setString(4, city.getShort_name());


            st.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void deleteCity(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM cities where id = ?");

            st.setLong(1, id);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
