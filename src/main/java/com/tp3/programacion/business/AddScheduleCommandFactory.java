package com.tp3.programacion.business;

import com.tp3.programacion.model.Car;
import com.tp3.programacion.model.Customer;
import com.tp3.programacion.model.Insurance;
import com.tp3.programacion.persistance.ListScheduleRepository;

import java.util.Date;

public class AddScheduleCommandFactory implements CommandFactory {
    private ListScheduleRepository repository;
    private Date date;
    private String professionalType;
    private Car car;
    private Insurance insurance;
    private Customer customer;

    public AddScheduleCommandFactory(Date date, String professionalType, Car car, Insurance insurance, Customer customer) {
        this.repository = ListScheduleRepository.getInstance();
        this.date = date;
        this.professionalType = professionalType;
        this.car = car;
        this.insurance = insurance;
        this.customer = customer;
    }

    public Command create() {
        return new AddScheduleCommand(repository, date, professionalType, car, insurance, customer);
    }
}
