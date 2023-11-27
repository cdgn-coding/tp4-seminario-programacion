package com.tp4.programacion.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@With
public class Insurance {
    private Long id;
    private String name;
    private String companyName;
}