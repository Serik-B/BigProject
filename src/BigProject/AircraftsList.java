package BigProject.I;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AircraftsList extends JPanel {
    private MainFrame parent;
    private JLabel label;
    private JButton back;
    private JButton update;

    private String header[] = {"Name","model ","business_class_capacity","econom_class_capacity"};
    private JTable table;
    private JScrollPane scrollPane;

    public AircraftsList(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("LIST OF AIRCRAFTS:");
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
                parent.getAircraftsList().setVisible(false);
                parent.getAircraftsPage().setVisible(true);
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


    public void generateTable(ArrayList<Aircrafts>aircrafts){
        Object data[][] = new Object[aircrafts.size()][4];

        for(int i =0;i<aircrafts.size();i++){
            data[i][0]=aircrafts.get(i).getName();
            data[i][1] = aircrafts.get(i).getModel();
            data[i][2] = aircrafts.get(i).getBusiness_class_capacity();
            data[i][3] = aircrafts.get(i).getEconom_class_capacity();

        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);

    }
}




