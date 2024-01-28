package com.postgresql.pharmacy.service.impl;

import com.postgresql.pharmacy.model.Pharmacy;
import com.postgresql.pharmacy.repository.PharmacyRepository;
import com.postgresql.pharmacy.service.PharmacyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacySrviceImplementation implements PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    public PharmacySrviceImplementation(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public List<Pharmacy> findAll() {
        return this.pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy save(String name, String address, String phoneNumber, String openHours) {
        Pharmacy p = new Pharmacy(name, address,phoneNumber,openHours);
        return pharmacyRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        pharmacyRepository.deleteById(id);
    }
}
