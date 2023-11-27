module com.tp4.programacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jakarta.persistence;
    requires static lombok;


    opens com.tp4.programacion to javafx.fxml;
    opens com.tp4.programacion.controller to javafx.fxml;
    opens com.tp4.programacion.persistance to javafx.fxml;
    opens com.tp4.programacion.model to javafx.fxml;
    opens com.tp4.programacion.business to javafx.fxml;
    opens com.tp4.programacion.persistance.hibernate to javafx.fxml;
    exports com.tp4.programacion;
}