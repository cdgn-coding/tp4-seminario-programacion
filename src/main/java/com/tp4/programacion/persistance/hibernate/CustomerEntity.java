package com.tp4.programacion.persistance.hibernate;

import com.tp4.programacion.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String identificationType;
    private String identificationNumber;
    private String phoneNumber;
    private String email;

    public Customer toDomain() {
        return new Customer(id, name, identificationType, identificationNumber, phoneNumber, email);
    }

    public static CustomerEntity fromDomain(Customer customer) {
        return new CustomerEntity(customer.getId(), customer.getName(), customer.getIdentificationType(), customer.getIdentificationNumber(), customer.getPhoneNumber(), customer.getEmail());
    }
}