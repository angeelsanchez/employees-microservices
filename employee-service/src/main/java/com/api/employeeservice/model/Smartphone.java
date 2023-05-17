package com.api.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Smartphone {
    private String brand;
    private String model;
    private int employeeId;
}
