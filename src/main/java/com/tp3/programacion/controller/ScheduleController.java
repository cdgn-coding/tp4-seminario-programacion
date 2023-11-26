package com.tp3.programacion.controller;

import com.tp3.programacion.business.AddScheduleCommandFactory;
import com.tp3.programacion.model.Car;
import com.tp3.programacion.model.Customer;
import com.tp3.programacion.model.Insurance;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleController {
    @FXML
    private TextField dateField;
    @FXML
    private TextField timeField;
    @FXML
    private TextField professionalField;
    @FXML
    private TextField brandField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField insuranceNameField;
    @FXML
    private TextField insuranceCompanyField;
    @FXML
    private TextField customerNameField;
    @FXML
    private TextField identificationTypeField;
    @FXML
    private TextField identificationNumberField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField emailField;

    @FXML
    private void createSchedule() {
        String professionalType = professionalField.getText();
        Car car = getCar();
        Insurance insurance = getInsurance();
        Customer customer = getCustomer();
        Date dateTime = getDateTime();
        new AddScheduleCommandFactory(dateTime, professionalType, car, insurance, customer)
                .create()
                .execute();

        clearFields();
    }

    private Insurance getInsurance() {
        String insuranceName = insuranceNameField.getText();
        String insuranceCompany = insuranceCompanyField.getText();
        Insurance insurance = new Insurance(insuranceName, insuranceCompany);
        return insurance;
    }

    private Customer getCustomer() {
        String customerName = customerNameField.getText();
        String identificationType = identificationTypeField.getText();
        String identificationNumber = identificationNumberField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        Customer customer = new Customer(customerName, identificationType, identificationNumber, phoneNumber, email);
        return customer;
    }

    private Car getCar() {
        try {
            // Crear instancias de Car, Insurance, Customer y Schedule
            String brand = brandField.getText();
            String model = modelField.getText();
            int year = Integer.parseInt(yearField.getText());
            Car car = new Car(brand, model, year);
            return car;
        } catch (NumberFormatException e) {
            showAlert("Error", "Año inválido.");
            return null;
        }
    }

    private Date getDateTime() {
        try {
            // Obtener los datos de la interfaz
            String date = dateField.getText();
            String time = timeField.getText();
            // Parsear la fecha y hora ingresadas
            String dateTimeStr = date + " " + time;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return dateFormat.parse(dateTimeStr);
        } catch (ParseException e) {
            showAlert("Error", "Fecha y hora inválidas.");
            return null;
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        // Limpiar todos los campos de entrada
        dateField.clear();
        timeField.clear();
        professionalField.clear();
        brandField.clear();
        modelField.clear();
        yearField.clear();
        insuranceNameField.clear();
        insuranceCompanyField.clear();
        customerNameField.clear();
        identificationTypeField.clear();
        identificationNumberField.clear();
        phoneNumberField.clear();
        emailField.clear();
    }
}
