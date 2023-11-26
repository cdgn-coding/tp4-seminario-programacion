package com.tp3.programacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScheduleApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(ScheduleApp.class.getResource("schedule-app.fxml"));
        Parent root = loader.load();

        stage.setTitle("Aplicación de Turnos");
        stage.setScene(new Scene(root, 400, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}