package com.api.smartphoneservice.repository;

import com.api.smartphoneservice.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {

    List<Smartphone> findByEmployeeId(int employeeId);

}
