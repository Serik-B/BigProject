package BigProject.I;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AircraftsPage extends JPanel {
    private MainFrame parent;
    private JButton aircraftsList;
    private JButton aircraftCreat;
    private JButton aircraftUpdate;
    private JButton aircraftDelete;
    private JButton back;
    public AircraftsPage (MainFrame parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);
        aircraftsList = new JButton("List");
        aircraftsList.setSize(300, 30);
        aircraftsList.setLocation(100, 50);
        add(aircraftsList);
        aircraftsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getAircraftsList().setVisible(true);
            }
        });

        aircraftCreat = new JButton("creat");
        aircraftCreat.setSize(300,30);
        aircraftCreat.setLocation(100,100);
        add(aircraftCreat);
        aircraftCreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getAircraftsCreat().setVisible(true);
            }

        });

        aircraftUpdate = new JButton("update");
        aircraftUpdate.setSize(300,30);
        aircraftUpdate.setLocation(100,150);
        add(aircraftUpdate);
        aircraftUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getAircraftsUpdate().setVisible(true);
            }

        });
        aircraftDelete = new JButton("delete");
        aircraftDelete.setSize(300,30);
        aircraftDelete.setLocation(100,200);
        add(aircraftDelete);
        aircraftDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsPage().setVisible(false);
                parent.getAircraftsDelete().setVisible(true);
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
                parent.getAircraftsPage().setVisible(false);
                parent.getAdminMainMenu().setVisible(true);
            }
        });

    }
}
