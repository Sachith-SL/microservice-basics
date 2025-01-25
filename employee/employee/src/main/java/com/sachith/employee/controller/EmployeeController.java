package com.sachith.employee.controller;

import com.sachith.employee.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping()
    public ResponseEntity<Employee> getEmployee(){

        //todo: take address from address service
        String address = restTemplate.getForObject("http://localhost:8081/v1/addresses",String.class);

        logger.info("Fetching employee details...");
        return ResponseEntity.ok(new Employee(1,"Sachith","0765510800", address));
    }
}
