package com.tp3.programacion.business;

import com.tp3.programacion.model.Car;
import com.tp3.programacion.model.Customer;
import com.tp3.programacion.model.Insurance;
import com.tp3.programacion.model.Schedule;
import com.tp3.programacion.persistance.*;

import java.util.Date;

public class AddScheduleCommand implements Command {
    private ListScheduleRepository repository;
    private Date date;
    private String professionalType;
    private Car car;
    private Insurance insurance;
    private Customer customer;

    public AddScheduleCommand(ListScheduleRepository repository, Date date, String professionalType, Car car, Insurance insurance, Customer customer) {
        this.repository = repository;
        this.date = date;
        this.professionalType = professionalType;
        this.car = car;
        this.insurance = insurance;
        this.customer = customer;
    }

    @Override
    public void execute() {
        Schedule schedule = Schedule.builder()
                .dateAndTime(date)
                .professionalType(professionalType)
                .car(car)
                .insurance(insurance)
                .customer(customer)
                .build();
        repository.addSchedule(schedule);
    }
}

