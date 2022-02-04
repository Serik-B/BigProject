package BigProject.I;

import BigProject.I.Flight.PackageData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightsCreat extends JPanel {private MainFrame parent;

    private JLabel label;

    private JButton buttonAdd;
    private JButton buttonBack;

    private JTextField textFieldId;
    private JTextField textFieldAircraft_id;
    private JTextField textFieldDeparture_city_id;
    private JTextField textFieldArrival_city_id;
    private JTextField textFieldDeparture_time;
    private JTextField textFieldEconom_place_price;
    private JTextField textFieldEusiness_place_price;




    public FlightsCreat(MainFrame parent){
        this.parent=parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("aircraft_id:");
        label.setSize(200, 30);
        label.setLocation(50, 40);
        add(label);

        textFieldAircraft_id = new JTextField("");
        textFieldAircraft_id.setSize(250,30);
        textFieldAircraft_id.setLocation(200, 40);
        add(textFieldAircraft_id);

        label = new JLabel("departure_city_id:");
        label.setSize(200, 30);
        label.setLocation(50,80);
        add(label);

        textFieldDeparture_city_id = new JTextField("");
        textFieldDeparture_city_id.setSize(250, 30);
        textFieldDeparture_city_id.setLocation(200, 80);
        add(textFieldDeparture_city_id);

        label = new JLabel("arrival_city_id: ");
        label.setSize(200, 30);
        label.setLocation(50,120);
        add(label);

        textFieldArrival_city_id = new JTextField("");
        textFieldArrival_city_id.setSize(250, 30);
        textFieldArrival_city_id.setLocation(200, 120);
        add(textFieldArrival_city_id);

        label = new JLabel("departure_time: ");
        label.setSize(200, 30);
        label.setLocation(50,160);
        add(label);

        textFieldDeparture_time = new JTextField("");
        textFieldDeparture_time.setSize(250, 30);
        textFieldDeparture_time.setLocation(200, 160);
        add(textFieldDeparture_time);



        label = new JLabel("econom_place_price: ");
        label.setSize(200, 30);
        label.setLocation(50,200);
        add(label);

        textFieldEconom_place_price = new JTextField("");
        textFieldEconom_place_price.setSize(250, 30);
        textFieldEconom_place_price.setLocation(200, 200);
        add(textFieldEconom_place_price);

        label = new JLabel("business_place_price: ");
        label.setSize(200, 30);
        label.setLocation(50,240);
        add(label);

        textFieldEusiness_place_price = new JTextField("");
        textFieldEusiness_place_price.setSize(250, 30);
        textFieldEusiness_place_price.setLocation(200, 240);
        add(textFieldEusiness_place_price);



        buttonAdd = new JButton("ADD");
        buttonAdd.setSize(125,30);
        buttonAdd.setLocation(100, 320);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldAircraft_id.getText()!= null &&
                        textFieldDeparture_city_id.getText()!=null &&
                        textFieldArrival_city_id.getText()!=null&&
                        textFieldDeparture_time.getText()!=null&&
                        textFieldEconom_place_price.getText()!=null&&
                        textFieldEusiness_place_price.getText()!=null){
                    Flights f = new Flights( null,Integer.parseInt(textFieldAircraft_id.getText()),
                            Integer.parseInt(textFieldDeparture_city_id.getText()),
                            Integer.parseInt(textFieldArrival_city_id.getText()),textFieldDeparture_time.getText()
                            ,Integer.parseInt(textFieldEconom_place_price.getText()),
                            Integer.parseInt(textFieldEusiness_place_price.getText()));
                    BigProject.I.Flight.PackageData pdf = new PackageData("ADD_AIRCRAFTS", null, f);
                    parent.setMessageF(pdf);
                    textFieldAircraft_id.setText("");
                    textFieldDeparture_city_id.setText("");
                    textFieldArrival_city_id.setText("");
                    textFieldDeparture_time.setText("");
                    textFieldEconom_place_price.setText("");
                    textFieldEusiness_place_price.setText("");

                }
            }
        });

        add(buttonAdd);

        buttonBack = new JButton("BACK");
        buttonBack.setSize(125,30);
        buttonBack.setLocation(275, 320);
        add(buttonBack);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsCreat().setVisible(false);
                parent.getFlightsPage().setVisible(true);
            }
        });
    }


}
