package com.tp4.programacion.persistance.hibernate;

import java.util.Date;

import com.tp4.programacion.model.Schedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Date dateAndTime;
    public String professionalType;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    public CarEntity car;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "insurance_id")
    public InsuranceEntity insurance;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    public CustomerEntity customer;

    public Schedule toDomain() {
        return new Schedule(id, dateAndTime, professionalType, car.toDomain(), insurance.toDomain(), customer.toDomain());
    }

    public static ScheduleEntity fromDomain(Schedule schedule) {
        return new ScheduleEntity(schedule.getId(), schedule.getDateAndTime(), schedule.getProfessionalType(), CarEntity.fromDomain(schedule.getCar()), InsuranceEntity.fromDomain(schedule.getInsurance()), CustomerEntity.fromDomain(schedule.getCustomer()));
    }
}
