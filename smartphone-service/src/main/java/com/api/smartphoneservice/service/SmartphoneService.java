package com.api.smartphoneservice.service;

import com.api.smartphoneservice.entity.Smartphone;
import com.api.smartphoneservice.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    public List<Smartphone> getAll() {
        return smartphoneRepository.findAll();
    }

    public Smartphone getSmartphoneById(int id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    public List<Smartphone> byEmployeeId(int employeeId) {
        return smartphoneRepository.findByEmployeeId(employeeId);
    }

}
