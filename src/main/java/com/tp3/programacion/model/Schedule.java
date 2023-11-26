package com.tp3.programacion.model;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@With
public class Schedule {
    private Long id;
    private Date dateAndTime;
    private String professionalType;
    private Car car;
    private Insurance insurance;
    private Customer customer;
}
