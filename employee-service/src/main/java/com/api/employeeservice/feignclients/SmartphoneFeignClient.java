package com.api.employeeservice.feignclients;

import com.api.employeeservice.model.Smartphone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "smartphone-service", url = "http://localhost:8003")
//@RequestMapping("/smartphone")
public interface SmartphoneFeignClient {

    @PostMapping("/smartphone")
    Smartphone save(@RequestBody Smartphone smarthphone);

    @GetMapping("smartphone/byemployee/{employeeId}")
    List<Smartphone> getSmartphones(@PathVariable("employeeId") int employeeId);

}
