package com.tp4.programacion.business;

import com.tp4.programacion.ScheduleApp;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;

@ExtendWith(ApplicationExtension.class)
public class ScheduleAppTest {
    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @SneakyThrows
    @Start
    private void start(Stage stage) {
        FXMLLoader loader = new FXMLLoader(ScheduleApp.class.getResource("schedule-app.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root, 400, 600));
        stage.show();
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void store_schedule(FxRobot robot) {
        robot.clickOn("#dateField");
        robot.write("2021-06-01");
        robot.clickOn("#timeField");
        robot.write("10:00");
        robot.clickOn("#professionalField");
        robot.write("Mecánico");
        robot.clickOn("#brandField");
        robot.write("Ford");
        robot.clickOn("#modelField");
        robot.write("Fiesta");
        robot.clickOn("#yearField");
        robot.write("2010");
        robot.clickOn("#insuranceNameField");
        robot.write("La Segunda");
        robot.clickOn("#insuranceCompanyField");
        robot.write("La Segunda");
        robot.clickOn("#customerNameField");
        robot.write("Juan Perez");
        robot.clickOn("#identificationTypeField");
        robot.write("DNI");
        robot.clickOn("#identificationNumberField");
        robot.write("12345678");
        robot.clickOn("#phoneNumberField");
        robot.write("1234567890");
        robot.clickOn("#emailField");
        robot.write("juanperez@email.com");
        robot.clickOn("#createSchedule");

        val resultText = robot.lookup("#alertDialog").queryAs(DialogPane.class).getHeaderText();
        Assertions.assertEquals("Se agendó correctamente.", resultText);
    }
}
