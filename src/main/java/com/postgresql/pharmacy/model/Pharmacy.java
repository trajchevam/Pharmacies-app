package com.postgresql.pharmacy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="pharmacy")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String openHours;

    public Pharmacy(String name, String address, String phoneNumber, String openHours) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.openHours = openHours;
    }

    public Pharmacy() {

    }
}
