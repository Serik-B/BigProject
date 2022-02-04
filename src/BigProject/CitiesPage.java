package BigProject.I;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitiesPage extends JPanel {
    private MainFrame parent;
    private JButton citiesList;
    private JButton citiesCreat;
    private JButton citiesUpdate;
    private JButton citiesDelete;
    private JButton back;
    public CitiesPage (MainFrame parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);
        citiesList = new JButton("List");
        citiesList.setSize(300, 30);
        citiesList.setLocation(100, 50);
        add(citiesList);
        citiesList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getCitiesList().setVisible(true);
            }
        });

        citiesCreat = new JButton("creat");
        citiesCreat.setSize(300,30);
        citiesCreat.setLocation(100,100);
        add(citiesCreat);
        citiesCreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getCitiesCreat().setVisible(true);
            }

        });

        citiesUpdate = new JButton("update");
        citiesUpdate.setSize(300,30);
        citiesUpdate.setLocation(100,150);
        add(citiesUpdate);
        citiesUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getCitiesUpdate().setVisible(true);
            }

        });
        citiesDelete = new JButton("delete");
        citiesDelete.setSize(300,30);
        citiesDelete.setLocation(100,200);
        add(citiesDelete);
        citiesDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesPage().setVisible(false);
                parent.getCitiesDelete().setVisible(true);
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
                parent.getCitiesPage().setVisible(false);
                parent.getAdminMainMenu().setVisible(true);
            }
        });

    }
}

