package com.tp4.programacion.business;

import com.tp4.programacion.model.Schedule;

import java.util.List;

public interface ScheduleService {
    void addSchedule(Schedule schedule);

    void update(Schedule schedule);

    List<Schedule> getAllSchedules();
}
