package BigProject.I;

import BigProject.I.Flight.PackageData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightsDelete extends JPanel {   private MainFrame parent;

    private JLabel label;

    private JButton buttonDelete;
    private JButton buttonBack;

    private JTextField textFieldId;

    public FlightsDelete(MainFrame parent) {
        this.parent = parent;

        setSize(500, 500);
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


                    BigProject.I.Flight.PackageData pdf = new PackageData("DELETE_FLIGHTS", null, null);
                    parent.setMessageF(pdf);
                    textFieldId.setText("");
                    Long index=Long.parseLong(textFieldId.getText());
//                    MainFrame.getDb().deleteFlight(index);
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
                parent.getFlightsDelete().setVisible(false);
                parent.getFlightsPage().setVisible(true);
            }
        });
    }
}
