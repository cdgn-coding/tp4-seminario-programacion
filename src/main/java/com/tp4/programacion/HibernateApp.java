package com.tp4.programacion;

import com.tp4.programacion.persistance.hibernate.HibernateScheduleRepository;
import lombok.val;

public class HibernateApp {
    public static void main(String[] args) {
        val repository = HibernateScheduleRepository.getInstance();
    }
}
