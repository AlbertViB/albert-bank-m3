module com.app.albertbank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.app.albertbank to javafx.fxml;
    exports com.app.albertbank;
}