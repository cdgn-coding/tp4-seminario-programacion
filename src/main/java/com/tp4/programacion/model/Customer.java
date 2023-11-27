package com.tp4.programacion.model;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@With
public class Customer {
    private Long id;
    private String name;
    private String identificationType;
    private String identificationNumber;
    private String phoneNumber;
    private String email;
}