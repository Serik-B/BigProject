package BigProject.I;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AircraftsUpdate extends JPanel {
    private MainFrame parent;

    private JLabel label;

    private JButton buttonUpdate;
    private JButton buttonBack;

    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldModel;
    private JTextField textFieldBusinessCC;
    private JTextField textFieldEconomCC;

    public AircraftsUpdate(MainFrame parent) {
        setSize(500, 500);
        setLayout(null);

        label = new JLabel("WHERE ID?");
        label.setSize(200, 30);
        label.setLocation(50, 40);
        add(label);

        textFieldId = new JTextField("");
        textFieldId.setSize(250, 30);
        textFieldId.setLocation(200, 40);
        add(textFieldId);

        label = new JLabel("WHERE NAME?");
        label.setSize(200, 30);
        label.setLocation(50, 80);
        add(label);

        textFieldName = new JTextField("");
        textFieldName.setSize(250, 30);
        textFieldName.setLocation(200, 80);
        add(textFieldName);

        label = new JLabel("WHERE MODEL?");
        label.setSize(200, 30);
        label.setLocation(50, 120);
        add(label);

        textFieldModel = new JTextField("");
        textFieldModel.setSize(250, 30);
        textFieldModel.setLocation(200, 120);
        add(textFieldModel);

        label = new JLabel("Business class capacity? ");
        label.setSize(200, 30);
        label.setLocation(50, 160);
        add(label);

        textFieldBusinessCC = new JTextField("");
        textFieldBusinessCC.setSize(250, 30);
        textFieldBusinessCC.setLocation(200, 160);
        add(textFieldBusinessCC);

        label = new JLabel("Econom_class_capacity? ");
        label.setSize(200, 30);
        label.setLocation(50, 200);
        add(label);

        textFieldEconomCC = new JTextField("");
        textFieldEconomCC.setSize(250, 30);
        textFieldEconomCC.setLocation(200, 200);
        add(textFieldEconomCC);


        buttonUpdate = new JButton("UPDATE");
        buttonUpdate.setSize(125, 30);
        buttonUpdate.setLocation(100, 260);

        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldId.getText()!=null && textFieldName.getText()!= null &&
                        textFieldModel.getText()!=null &&
                        textFieldBusinessCC.getText()!=null&&textFieldEconomCC!=null){
                    Aircrafts a = new Aircrafts( Long.parseLong(textFieldId.getText()),textFieldName.getText(),textFieldModel.getText(),
                            Integer.parseInt(textFieldBusinessCC.getText()),Integer.parseInt(textFieldEconomCC.getText()));
                    PackageData pd = new PackageData("UPDATE_AIRCRAFTS", null, a);
                    parent.setMessage(pd);
                    textFieldId.setText("");
                    textFieldModel.setText("");
                    textFieldName.setText("");
                    textFieldBusinessCC.setText("");
                    textFieldEconomCC.setText("");

                    MainFrame.getDb().updateAircraft(a);
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
                parent.getAircraftsUpdate().setVisible(false);
                parent.getAircraftsPage().setVisible(true);
            }
        });
    }
}
