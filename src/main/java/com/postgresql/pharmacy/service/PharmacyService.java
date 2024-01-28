package com.postgresql.pharmacy.service;
import com.postgresql.pharmacy.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    List<Pharmacy> findAll();
    Pharmacy save (String name, String address, String phoneNumber, String openHours);
    void delete(Long id);
}
