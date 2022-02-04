package BigProject.I;

import BigProject.I.City.PackageData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitiesUpdate extends JPanel {
    private MainFrame parent;
    private JLabel label;
    private JButton buttonUpdate;
    private JButton buttonBack;
    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldCountry;
    private JTextField textFieldShortName;

    public CitiesUpdate(MainFrame parent){
        setSize(500, 300);
        setLayout(null);

        label = new JLabel("WHERE ID?");
        label.setSize(100, 30);
        label.setLocation(50, 40);
        add(label);

        textFieldId = new JTextField("");
        textFieldId.setSize(250, 30);
        textFieldId.setLocation(180, 40);
        add(textFieldId);

        label = new JLabel("WHERE NAME?");
        label.setSize(150, 30);
        label.setLocation(50, 80);
        add(label);

        textFieldName = new JTextField("");
        textFieldName.setSize(250, 30);
        textFieldName.setLocation(180, 80);
        add(textFieldName);

        label = new JLabel("WHERE COUNTRY?");
        label.setSize(150, 30);
        label.setLocation(50, 120);
        add(label);

        textFieldCountry = new JTextField("");
        textFieldCountry.setSize(250, 30);
        textFieldCountry.setLocation(180, 120);
        add(textFieldCountry);

        label = new JLabel("SHORT NAME? ");
        label.setSize(150, 30);
        label.setLocation(50, 160);
        add(label);

        textFieldShortName = new JTextField("");
        textFieldShortName.setSize(250, 30);
        textFieldShortName.setLocation(180, 160);
        add(textFieldShortName);




        buttonUpdate = new JButton("UPDATE");
        buttonUpdate.setSize(125, 30);
        buttonUpdate.setLocation(100, 260);

        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldId.getText()!=null && textFieldName.getText()!= null &&
                        textFieldCountry.getText()!=null &&
                        textFieldShortName.getText()!=null){
                    Cities c = new Cities( Long.parseLong(textFieldId.getText()),textFieldName.getText(),textFieldCountry.getText(),
                           textFieldShortName.getText());
                    BigProject.I.City.PackageData pdc = new PackageData("UPDATE_CITIES", null, c);
                    parent.setMessageC(pdc);
                    textFieldId.setText("");
                    textFieldCountry.setText("");
                    textFieldName.setText("");
                    textFieldShortName.setText("");
                    MainFrame.getDb().updateCity(c);
                }
            }
        });

        add(buttonUpdate);



        buttonBack = new JButton("BACK");
        buttonBack.setSize(125,30);
        buttonBack.setLocation(275, 260);
        add(buttonBack);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesUpdate().setVisible(false);
                parent.getCitiesPage().setVisible(true);
            }
        });
    }
}
