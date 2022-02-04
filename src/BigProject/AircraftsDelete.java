package BigProject.I;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AircraftsDelete extends JPanel {
    private MainFrame parent;

    private JLabel label;

    private JButton buttonDelete;
    private JButton buttonBack;

    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldModel;
    private JTextField textFieldBusinessCC;
    private JTextField textFieldEconomCC;
    public AircraftsDelete(MainFrame parent) {
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


                    PackageData pd = new PackageData("DELETE_AIRCRAFTS", null, null);
                    parent.setMessage(pd);
                    textFieldId.setText("");
                    Long index=Long.parseLong(textFieldId.getText());
                    MainFrame.getDb().deleteAircraft(index);
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
                parent.getAircraftsDelete().setVisible(false);
                parent.getAircraftsPage().setVisible(true);
            }
        });
    }
}
