module com.example.bigproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bigproject to javafx.fxml;
    exports com.example.bigproject;
}