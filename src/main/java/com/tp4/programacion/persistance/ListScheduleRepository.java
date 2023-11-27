package com.tp4.programacion.persistance;

/**
 * Singleton
 */
import com.tp4.programacion.business.ScheduleService;
import com.tp4.programacion.model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ListScheduleRepository implements ScheduleService {
    private static ListScheduleRepository instance;
    private List<Schedule> scheduleList;

    private Long counter = 0L;

    private ListScheduleRepository() {
        // Inicializar la lista de turnos
        scheduleList = new ArrayList<>();
    }

    public static ListScheduleRepository getInstance() {
        if (instance == null) {
            synchronized (ListScheduleRepository.class) {
                if (instance == null) {
                    instance = new ListScheduleRepository();
                }
            }
        }
        return instance;
    }

    public void addSchedule(Schedule schedule) {
        schedule.setId(counter++);
        scheduleList.add(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleList;
    }

    public void update(Schedule schedule) {
        for (int i = 0; i < scheduleList.size(); i++) {
            if (scheduleList.get(i).getId() == schedule.getId()) {
                scheduleList.set(i, schedule);
                break;
            }
        }
    }
}
