package BigProject.I;

import BigProject.I.City.PackageData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitiesDelete extends JPanel {
    private MainFrame parent;

    private JLabel label;

    private JButton buttonDelete;
    private JButton buttonBack;

    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldCountry;
    private JTextField textFieldShort_Name;

    public CitiesDelete(MainFrame parent){
        this.parent = parent;

        setSize(500, 300);
        setLayout(null);

        label = new JLabel("ID?:");
        label.setSize(100, 30);
        label.setLocation(70, 40);
        add(label);

        textFieldId = new JTextField("");
        textFieldId.setSize(300, 30);
        textFieldId.setLocation(120, 40);
        add(textFieldId);

        buttonDelete=new JButton("DELETE");
        buttonDelete.setSize(125,30);
        buttonDelete.setLocation(100, 260);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldId.getText()!=null){
//                    Aircrafts a = new Aircrafts( null,textFieldName.getText(),textFieldModel.getText(),
//                            Integer.parseInt(textFieldBusinessCC.getText()),Integer.parseInt(textFieldEconomCC.getText()));

                    BigProject.I.City.PackageData pdc = new PackageData("DELETE_CITIES", null, null);
                    parent.setMessageC(pdc);
                    textFieldId.setText("");
                    Long id=Long.parseLong(textFieldId.getText());
//                    MainFrame.getDb().deleteAircraft(Long.parseLong(textFieldId.getText()));
                    MainFrame.getDb().deleteCity(id);
                }
            }
        });
        add(buttonDelete);

        buttonBack = new JButton("BACK");
        buttonBack.setSize(125,30);
        buttonBack.setLocation(275, 260);
        add(buttonBack);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getCitiesDelete().setVisible(false);
                parent.getCitiesPage().setVisible(true);
            }
        });
    }
}
