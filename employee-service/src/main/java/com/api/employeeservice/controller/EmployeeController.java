package com.api.employeeservice.controller;

import com.api.employeeservice.entity.Employee;
import com.api.employeeservice.model.Laptop;
import com.api.employeeservice.model.Smartphone;
import com.api.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.getAll();
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee newEmployee) {
        return ResponseEntity.ok(employeeService.save(newEmployee));
    }

    @PostMapping("/savelaptop/{employeeId}")
    public ResponseEntity<Laptop> saveLaptop(@PathVariable("employeeId") int employeeId, @RequestBody Laptop laptop) {
        if (employeeService.getEmployeeById(employeeId) == null)
            return ResponseEntity.notFound().build();

        Laptop newLaptop = employeeService.saveLaptop(employeeId, laptop);
        return ResponseEntity.ok(newLaptop);
    }

    @PostMapping("/savesmartphone/{employeeId}")
    public ResponseEntity<Smartphone> saveSmartphone(@PathVariable("employeeId") int employeeId, @RequestBody Smartphone smartphone) {
        if (employeeService.getEmployeeById(employeeId) == null)
            return ResponseEntity.notFound().build();

        Smartphone newSmartphone = employeeService.saveSmarthphone(employeeId, smartphone);
        return ResponseEntity.ok(newSmartphone);
    }

    @GetMapping("/laptops/{employeeId}")
    public ResponseEntity<List<Laptop>> getLaptopsByEmployeeId(@PathVariable("employeeId") int employeeId) {
        List<Laptop> laptops = employeeService.getLaptopsByEmployeeId(employeeId);
        if (laptops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(laptops);
    }


    @GetMapping("/smartphones/{employeeId}")
    public ResponseEntity<List<Smartphone>> getSmartphonesByEmployeeId(@PathVariable("employeeId") int employeeId) {
        List<Smartphone> smartphones = employeeService.getSmartphonesByEmployeeId(employeeId);
        if (smartphones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(smartphones);
    }

    @GetMapping("/getAll/{employeeId}")
    public ResponseEntity<Map<String, Object>> getAll(@PathVariable("employeeId") int employeeId) {
        Map<String, Object> result = employeeService.getEmployeeAndInventory(employeeId);
        return ResponseEntity.ok(result);
    }

}
