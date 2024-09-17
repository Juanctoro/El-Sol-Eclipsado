module com.example.elsoleclipsado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.elsoleclipsado to javafx.fxml;
    exports com.example.elsoleclipsado;
    exports com.example.elsoleclipsado.controller;
    opens com.example.elsoleclipsado.controller to javafx.fxml;
    exports com.example.elsoleclipsado.models;
    opens com.example.elsoleclipsado.models to javafx.fxml;
}