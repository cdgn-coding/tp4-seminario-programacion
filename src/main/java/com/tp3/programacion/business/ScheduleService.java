package com.tp3.programacion.business;

import com.tp3.programacion.model.Schedule;

import java.util.List;

public interface ScheduleService {
    void addSchedule(Schedule schedule);

    void update(Schedule schedule);

    List<Schedule> getAllSchedules();
}
