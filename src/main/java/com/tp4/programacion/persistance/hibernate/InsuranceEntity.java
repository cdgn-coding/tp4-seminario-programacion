package com.tp4.programacion.persistance.hibernate;


import com.tp4.programacion.model.Insurance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Insurance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String companyName;

    public Insurance toDomain() {
        return new Insurance(id, name, companyName);
    }

    public static InsuranceEntity fromDomain(Insurance insurance) {
        return new InsuranceEntity(insurance.getId(), insurance.getName(), insurance.getCompanyName());
    }
}