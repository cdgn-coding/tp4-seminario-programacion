package com.tp4.programacion.business;

import com.tp4.programacion.model.Schedule;
import com.tp4.programacion.persistance.ListScheduleRepository;

import java.util.Date;

public class ChangeScheduleDateTimeCommand implements Command {
    private ListScheduleRepository repository;
    private Schedule schedule;
    private Date newDateAndTime;

    public ChangeScheduleDateTimeCommand(ListScheduleRepository repository, Schedule schedule, Date newDateAndTime) {
        this.repository = repository;
        this.schedule = schedule;
        this.newDateAndTime = newDateAndTime;
    }

    @Override
    public void execute() {
        schedule.setDateAndTime(newDateAndTime);
        repository.update(schedule);
    }
}
