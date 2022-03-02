package com.employees.employees.controller;

import com.employees.employees.dto.EmployeeDTO;
import com.employees.employees.model.EmployeeModel;
import com.employees.employees.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAllEmployees(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<EmployeeDTO>(service.save(employeeDTO), HttpStatus.CREATED);

    }



}
