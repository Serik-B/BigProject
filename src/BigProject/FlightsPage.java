package BigProject.I;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightsPage extends JPanel {   private MainFrame parent;
    private JButton flightsList;
    private JButton flightsCreat;
    private JButton flightsUpdate;
    private JButton flightsDelete;
    private JButton back;
    public FlightsPage (MainFrame parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);
        flightsList = new JButton("List");
        flightsList.setSize(300, 30);
        flightsList.setLocation(100, 50);
        add(flightsList);
        flightsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getFlightsList().setVisible(true);
            }
        });

        flightsCreat = new JButton("creat");
        flightsCreat.setSize(300,30);
        flightsCreat.setLocation(100,100);
        add(flightsCreat);
        flightsCreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getFlightsCreat().setVisible(true);
            }

        });

        flightsUpdate = new JButton("update");
        flightsUpdate.setSize(300,30);
        flightsUpdate.setLocation(100,150);
        add(flightsUpdate);
        flightsUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getFlightsUpdate().setVisible(true);
            }

        });
        flightsDelete = new JButton("delete");
        flightsDelete.setSize(300,30);
        flightsDelete.setLocation(100,200);
        add(flightsDelete);
        flightsDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFlightsPage().setVisible(false);
                parent.getFlightsDelete().setVisible(true);
            }

        });


        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,250);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  parent.getAddStudentPage().setVisible(false);
                parent.getFlightsPage().setVisible(false);
                parent.getAdminMainMenu().setVisible(true);
            }
        });

    }
}