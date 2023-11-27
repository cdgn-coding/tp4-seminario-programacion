package com.tp4.programacion;

import com.tp4.programacion.model.Car;
import com.tp4.programacion.model.Customer;
import com.tp4.programacion.model.Insurance;
import com.tp4.programacion.model.Schedule;
import com.tp4.programacion.persistance.hibernate.HibernateScheduleRepository;
import lombok.val;

import java.util.Date;

public class HibernateApp {
    public static void main(String[] args) {
        val repository = HibernateScheduleRepository.getInstance();
        repository.addSchedule(Schedule.builder()
                .dateAndTime(new Date())
                .professionalType("Mecánico")
                        .insurance(Insurance.builder()
                                .name("La Caja")
                                .companyName("La Caja")
                                .build())
                        .car(Car.builder()
                                .brand("Ford")
                                .model("Fiesta")
                                .build())
                        .customer(Customer.builder()
                                .name("John")
                                .email("john@gmail.com")
                                .identificationNumber("12345678")
                                .identificationType("DNI")
                                .build())
                .build());
    }
}
