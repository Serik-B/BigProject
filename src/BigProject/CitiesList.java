package BigProject.I;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CitiesList extends JPanel {private MainFrame parent;
    private JLabel label;
    private JButton back;
    private JButton update;

    private String header[] = {"Name","country","short_name "};
    private JTable table;
    private JScrollPane scrollPane;

    public CitiesList(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("LIST OF CITIES:");
        label.setSize(300,30);
        label.setLocation(10,10);
        add(label);

        back = new JButton("BACK");
        back.setSize(300,30);
        back.setLocation(100,220);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  parent.getAddStudentPage().setVisible(false);
                parent.getCitiesList().setVisible(false);
                parent.getCitiesPage().setVisible(true);
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

    public void generateTable(ArrayList<Cities> cities){
        Object data[][] = new Object[cities.size()][3];

        for(int i =0;i<cities.size();i++){
            data[i][0]=cities.get(i).getName();
            data[i][1] = cities.get(i).getCountry();
            data[i][2] = cities.get(i).getShort_name();

        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);

    }
}

