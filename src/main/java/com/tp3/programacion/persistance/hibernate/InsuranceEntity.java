package com.tp3.programacion.persistance.hibernate;


import com.tp3.programacion.model.Insurance;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Insurance")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String companyName;

    public Insurance toDomain() {
        return new Insurance(id, name, companyName);
    }

    public static InsuranceEntity fromDomain(Insurance insurance) {
        return new InsuranceEntity(insurance.getId(), insurance.getName(), insurance.getCompanyName());
    }
}