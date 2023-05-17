package com.api.laptopservice.service;

import com.api.laptopservice.entity.Laptop;
import com.api.laptopservice.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    public List<Laptop> getAll() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(int id) {
        return laptopRepository.findById(id).orElse(null);
    }

    public Laptop save(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public List<Laptop> byEmployeeId(int employeeId) {
        return laptopRepository.findByEmployeeId(employeeId);
    }

}
