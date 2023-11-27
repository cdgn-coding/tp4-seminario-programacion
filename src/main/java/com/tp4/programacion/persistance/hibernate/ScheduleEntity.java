package com.tp4.programacion.persistance.hibernate;

import java.util.Date;

import com.tp4.programacion.model.Schedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Schedule")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Date dateAndTime;
    private String professionalType;
    @OneToOne
    private CarEntity car;
    @OneToOne
    private InsuranceEntity insurance;
    @OneToOne
    private CustomerEntity customer;

    public Schedule toDomain() {
        return new Schedule(id, dateAndTime, professionalType, car.toDomain(), insurance.toDomain(), customer.toDomain());
    }

    public static ScheduleEntity fromDomain(Schedule schedule) {
        return new ScheduleEntity(schedule.getId(), schedule.getDateAndTime(), schedule.getProfessionalType(), CarEntity.fromDomain(schedule.getCar()), InsuranceEntity.fromDomain(schedule.getInsurance()), CustomerEntity.fromDomain(schedule.getCustomer()));
    }
}
