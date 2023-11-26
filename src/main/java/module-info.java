module com.tp3.programacion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jakarta.persistence;
    requires lombok;

    opens com.tp3.programacion to javafx.fxml;
    opens com.tp3.programacion.controller to javafx.fxml;
    opens com.tp3.programacion.persistance to javafx.fxml;
    exports com.tp3.programacion;
    opens com.tp3.programacion.model to javafx.fxml;
    opens com.tp3.programacion.business to javafx.fxml;
    opens com.tp3.programacion.persistance.hibernate to javafx.fxml;
}