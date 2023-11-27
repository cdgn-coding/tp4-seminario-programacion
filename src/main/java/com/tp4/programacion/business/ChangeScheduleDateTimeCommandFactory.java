package com.tp4.programacion.business;

import com.tp4.programacion.model.Schedule;
import com.tp4.programacion.persistance.ListScheduleRepository;

import java.util.Date;

public class ChangeScheduleDateTimeCommandFactory implements CommandFactory {
    private ListScheduleRepository repository;
    private Schedule schedule;
    private Date newDateAndTime;

    public ChangeScheduleDateTimeCommandFactory(ListScheduleRepository repository, Schedule schedule, Date newDateAndTime) {
        this.repository = repository;
        this.schedule = schedule;
        this.newDateAndTime = newDateAndTime;
    }

    @Override
    public Command create() {
        return new ChangeScheduleDateTimeCommand(repository, schedule, newDateAndTime);
    }
}
