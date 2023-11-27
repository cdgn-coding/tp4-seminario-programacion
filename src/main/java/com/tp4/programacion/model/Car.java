package com.tp4.programacion.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@With
public class Car {
    private Long id;
    private String brand;
    private String model;
    private int year;
}