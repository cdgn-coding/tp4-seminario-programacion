package com.tp4.programacion.business;

import com.tp4.programacion.model.Car;
import com.tp4.programacion.model.Customer;
import com.tp4.programacion.model.Insurance;
import com.tp4.programacion.model.Schedule;
import com.tp4.programacion.persistance.ListScheduleRepository;

import java.util.Date;

public class AddScheduleCommand implements Command {
    private ScheduleService repository;
    private Date date;
    private String professionalType;
    private Car car;
    private Insurance insurance;
    private Customer customer;

    public AddScheduleCommand(ScheduleService repository, Date date, String professionalType, Car car, Insurance insurance, Customer customer) {
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

