package com.api.laptopservice.controller;

import com.api.laptopservice.entity.Laptop;
import com.api.laptopservice.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @GetMapping
    public ResponseEntity<List<Laptop>> getAll() {
        List<Laptop> laptops = laptopService.getAll();
        if (laptops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(laptops);
    }

    @GetMapping("{id}")
    public ResponseEntity<Laptop> getById(@PathVariable("id") int id) {
        Laptop laptop = laptopService.getLaptopById(id);
        if (laptop == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptop);
    }

    @PostMapping
    public ResponseEntity<Laptop> save(@RequestBody Laptop newLaptop) {
        return ResponseEntity.ok(laptopService.save(newLaptop));
    }

    @GetMapping("/byemployee/{employeeId}")
    public ResponseEntity<List<Laptop>> getByEmployeeId(@PathVariable("employeeId") int employeeId) {
        List<Laptop> laptops = laptopService.byEmployeeId(employeeId);
        if (laptops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(laptops);
    }

}
