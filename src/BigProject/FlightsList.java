package BigProject.I;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlightsList extends JPanel { private MainFrame parent;
    private JLabel label;
    private JButton back;
    private JButton update;

    private String header[] = {"aircr_id","dep_city_id ","arriv_city_id","dep_time","eco_place_price","busi_place_price"};
    private JTable table;
    private JScrollPane scrollPane;

    public FlightsList(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("LIST OF FLIGHTS:");
        label.setSize(300,30);
        label.setLocation(10,10);
        add(label);

        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,220);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  parent.getAddStudentPage().setVisible(false);
                parent.getFlightsList().setVisible(false);
                parent.getFlightsPage().setVisible(true);
            }
        });




        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(460,150);
        scrollPane.setLocation(10,50);
        add(scrollPane);
    }


    public void generateTable(ArrayList<Flights> flights){
        Object data[][] = new Object[flights.size()][6];

        for(int i =0;i<flights.size();i++){
            data[i][0]=flights.get(i).getAircraft_id();
            data[i][1] = flights.get(i).getDeparture_city_id();
            data[i][2] = flights.get(i).getArrival_city_id();
            data[i][3] = flights.get(i).getDeparture_time();
            data[i][4] = flights.get(i).getEconom_place_price();
            data[i][5] = flights.get(i).getBusiness_place_price();


        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);

    }
}
