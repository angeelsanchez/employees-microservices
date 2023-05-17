package com.api.employeeservice.feignclients;

import com.api.employeeservice.model.Laptop;
import com.api.employeeservice.model.Smartphone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "laptop-service", url = "http://localhost:8002")
//@RequestMapping("/laptop")
public interface LaptopFeignClient {

    @PostMapping("/laptop")
    Laptop save(@RequestBody Laptop newLaptop);

    @GetMapping("laptop/byemployee/{employeeId}")
    List<Laptop> getLaptops(@PathVariable("employeeId") int employeeId);

}
