package BigProject.I;

import BigProject.I.City.PackageData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitiesCreat extends JPanel {
    private MainFrame parent;

    private JLabel label;

    private JButton buttonAdd;
    private JButton buttonBack;

    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldCountry;
    private JTextField textFieldShortName;


    public CitiesCreat(MainFrame parent){
        this.parent=parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("NAME:");
        label.setSize(100, 30);
        label.setLocation(50, 40);
        add(label);

        textFieldName = new JTextField("");
        textFieldName.setSize(250,30);
        textFieldName.setLocation(150, 40);
        add(textFieldName);

        label = new JLabel("COUNTRY:");
        label.setSize(100, 30);
        label.setLocation(50,80);
        add(label);

        textFieldCountry = new JTextField("");
        textFieldCountry.setSize(250, 30);
        textFieldCountry.setLocation(150, 80);
        add(textFieldCountry);

        label = new JLabel("SHORT_NAME");
        label.setSize(100, 30);
        label.setLocation(50,120);
        add(label);

        textFieldShortName = new JTextField("");
        textFieldShortName.setSize(250, 30);
        textFieldShortName.setLocation(150, 120);
        add(textFieldShortName);




        buttonAdd = new JButton("ADD");
        buttonAdd.setSize(125,30);
        buttonAdd.setLocation(100, 220);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldName.getText()!= null &&
                        textFieldCountry.getText()!=null &&
                        textFieldShortName.getText()!=null){
                    Cities c = new Cities( null,textFieldName.getText(),textFieldCountry.getText(),textFieldShortName.getText());
                    BigProject.I.City.PackageData pdc = new PackageData("ADD_CITIES", null, c);
                    parent.setMessageC(pdc);
                    textFieldCountry.setText("");
                    textFieldShortName.setText("");
                    textFieldName.setText("");
                }
            }
        });

        add(buttonAdd);

        buttonBack = new JButton("BACK");
        buttonBack.setSize(125,30);
        buttonBack.setLocation(275, 220);
        add(buttonBack);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesCreat().setVisible(false);
                parent.getCitiesPage().setVisible(true);
            }
        });
    }


}