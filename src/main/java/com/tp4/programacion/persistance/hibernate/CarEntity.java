package com.tp4.programacion.persistance.hibernate;

import com.tp4.programacion.model.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Car")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private int year;

    public Car toDomain() {
        return new Car(id, brand, model, year);
    }

    public static CarEntity fromDomain(Car car) {
        return new CarEntity(car.getId(), car.getBrand(), car.getModel(), car.getYear());
    }
}