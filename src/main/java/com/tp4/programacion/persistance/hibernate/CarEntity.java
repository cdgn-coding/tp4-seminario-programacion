package com.tp4.programacion.persistance.hibernate;

import com.tp4.programacion.model.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String brand;
    public String model;
    public int year;

    public Car toDomain() {
        return new Car(id, brand, model, year);
    }

    public static CarEntity fromDomain(Car car) {
        return new CarEntity(car.getId(), car.getBrand(), car.getModel(), car.getYear());
    }
}