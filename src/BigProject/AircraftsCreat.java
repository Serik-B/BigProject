package BigProject.I;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AircraftsCreat extends JPanel {
    private MainFrame parent;

    private JLabel label;

    private JButton buttonAdd;
    private JButton buttonBack;

    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldModel;
    private JTextField textFieldBusinessCC;
    private JTextField textFieldEconomCC;


    public AircraftsCreat(MainFrame parent){
        this.parent=parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("NAME:");
        label.setSize(200, 30);
        label.setLocation(50, 40);
        add(label);

        textFieldName = new JTextField("");
        textFieldName.setSize(250,30);
        textFieldName.setLocation(200, 40);
        add(textFieldName);

        label = new JLabel("MODEL:");
        label.setSize(200, 30);
        label.setLocation(50,80);
        add(label);

        textFieldModel = new JTextField("");
        textFieldModel.setSize(250, 30);
        textFieldModel.setLocation(200, 80);
        add(textFieldModel);

        label = new JLabel("Business class capacity: ");
        label.setSize(200, 30);
        label.setLocation(50,120);
        add(label);

        textFieldBusinessCC = new JTextField("");
        textFieldBusinessCC.setSize(250, 30);
        textFieldBusinessCC.setLocation(200, 120);
        add(textFieldBusinessCC);

        label = new JLabel("Econom_class_capacity: ");
        label.setSize(200, 30);
        label.setLocation(50,160);
        add(label);

        textFieldEconomCC = new JTextField("");
        textFieldEconomCC.setSize(250, 30);
        textFieldEconomCC.setLocation(200, 160);
        add(textFieldEconomCC);



        buttonAdd = new JButton("ADD");
        buttonAdd.setSize(125,30);
        buttonAdd.setLocation(100, 260);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldName.getText()!= null &&
                        textFieldModel.getText()!=null &&
                        textFieldBusinessCC.getText()!=null&&
                textFieldEconomCC.getText()!=null){
                    Aircrafts a = new Aircrafts( null,textFieldName.getText(),textFieldModel.getText(),Integer.parseInt(textFieldBusinessCC.getText()),Integer.parseInt(textFieldEconomCC.getText()));
                    PackageData pd = new PackageData("ADD_AIRCRAFTS", null, a);
                    parent.setMessage(pd);
                    textFieldBusinessCC.setText("");
                    textFieldEconomCC.setText("");
                    textFieldName.setText("");
                    textFieldModel.setText("");
                }
            }
        });

        add(buttonAdd);

        buttonBack = new JButton("BACK");
        buttonBack.setSize(125,30);
        buttonBack.setLocation(275, 260);
        add(buttonBack);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAircraftsCreat().setVisible(false);
                parent.getAircraftsPage().setVisible(true);
            }
        });
    }


}
