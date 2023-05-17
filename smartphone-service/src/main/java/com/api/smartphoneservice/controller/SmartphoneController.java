package com.api.smartphoneservice.controller;

import com.api.smartphoneservice.entity.Smartphone;
import com.api.smartphoneservice.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smartphone")
public class SmartphoneController {

    @Autowired
    SmartphoneService smartphoneService;

    @GetMapping
    public ResponseEntity<List<Smartphone>> getAll() {
        List<Smartphone> smartphones = smartphoneService.getAll();
        if (smartphones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(smartphones);
    }

    @GetMapping("{id}")
    public ResponseEntity<Smartphone> getById(@PathVariable("id") int id) {
        Smartphone smartphone = smartphoneService.getSmartphoneById(id);
        if (smartphone == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(smartphone);
    }

    @PostMapping
    public ResponseEntity<Smartphone> save(@RequestBody Smartphone newSmartphone) {
        return ResponseEntity.ok(smartphoneService.save(newSmartphone));
    }

    @GetMapping("/byemployee/{employeeId}")
    public ResponseEntity<List<Smartphone>> getByEmployeeId(@PathVariable("employeeId") int employeeId) {
        List<Smartphone> smartphones = smartphoneService.byEmployeeId(employeeId);
        if (smartphones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(smartphones);
    }

}
