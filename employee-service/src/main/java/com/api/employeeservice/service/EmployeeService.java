package com.api.employeeservice.service;

import com.api.employeeservice.entity.Employee;
import com.api.employeeservice.feignclients.LaptopFeignClient;
import com.api.employeeservice.feignclients.SmartphoneFeignClient;
import com.api.employeeservice.model.Laptop;
import com.api.employeeservice.model.Smartphone;
import com.api.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SmartphoneFeignClient smartphoneFeignClient;

    @Autowired
    LaptopFeignClient laptopFeignClient;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Laptop saveLaptop(int employeeId, Laptop newLaptop) {
        newLaptop.setEmployeeId(employeeId);
        return laptopFeignClient.save(newLaptop);
    }

    public Smartphone saveSmarthphone(int employeeId, Smartphone newSmartphone) {
        newSmartphone.setEmployeeId(employeeId);
        return smartphoneFeignClient.save(newSmartphone);
    }

    public List<Laptop> getLaptopsByEmployeeId(int employeeId) {
        return laptopFeignClient.getLaptops(employeeId);
    }

    public List<Smartphone> getSmartphonesByEmployeeId(int employeeId) {
        return smartphoneFeignClient.getSmartphones(employeeId);
    }

    public Map<String, Object> getEmployeeAndInventory(int employeeId) {
        Map<String, Object> result = new HashMap<>();
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            result.put("Mensaje", "Este empleado no existe");
            return result;
        }

        result.put("Employee", employee);

        List<Smartphone> smartphones = smartphoneFeignClient.getSmartphones(employeeId);
        if (smartphones == null) {
            result.put("Smartphones", "No se pudo obtener la lista de smartphones");
        } else {
            result.put("Smartphones", smartphones);
        }

        List<Laptop> laptops = laptopFeignClient.getLaptops(employeeId);
        if (laptops == null) {
            result.put("Laptops", "No se pudo obtener la lista de laptops");
        } else {
            result.put("Laptops", laptops);
        }

        return result;
    }



}
