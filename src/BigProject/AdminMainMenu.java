package BigProject.I;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenu extends JPanel {
    private MainFrame parent;
    private JButton aircraftsPage;
    private JButton citiesPage;
    private JButton flightsPage;
    private JButton exitButton;

    public AdminMainMenu(MainFrame parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);
        aircraftsPage = new JButton("Aircrafts");
        aircraftsPage.setSize(300, 30);
        aircraftsPage.setLocation(100, 50);
        add(aircraftsPage);
        aircraftsPage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            parent.getAdminMainMenu().setVisible(false);
            parent.getAircraftsPage().setVisible(true);
        }
    });

        citiesPage = new JButton("Cities");
        citiesPage.setSize(300,30);
        citiesPage.setLocation(100,100);
    add(citiesPage);
        citiesPage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            parent.getAdminMainMenu().setVisible(false);
            parent.getCitiesPage().setVisible(true);
        }

    });

        flightsPage = new JButton("Flights");
        flightsPage.setSize(300,30);
        flightsPage.setLocation(100,150);
        add(flightsPage);
        flightsPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAdminMainMenu().setVisible(false);
                parent.getFlightsPage().setVisible(true);
            }

        });


    exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,200);
    add(exitButton);
        exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    });

}
}
