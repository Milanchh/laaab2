module com.example.csd214lab2milan {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.naming;
    requires java.sql;
    requires com.fasterxml.jackson.annotation;

    opens com.example.csd214lab2milan to javafx.fxml;
    exports com.example.csd214lab2milan;
}