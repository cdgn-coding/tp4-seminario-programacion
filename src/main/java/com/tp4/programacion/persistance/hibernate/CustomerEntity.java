package com.tp4.programacion.persistance.hibernate;

import com.tp4.programacion.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String identificationType;
    public String identificationNumber;
    public String phoneNumber;
    public String email;

    public Customer toDomain() {
        return new Customer(id, name, identificationType, identificationNumber, phoneNumber, email);
    }

    public static CustomerEntity fromDomain(Customer customer) {
        return new CustomerEntity(customer.getId(), customer.getName(), customer.getIdentificationType(), customer.getIdentificationNumber(), customer.getPhoneNumber(), customer.getEmail());
    }
}