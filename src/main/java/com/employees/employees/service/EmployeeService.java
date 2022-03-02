package com.employees.employees.service;

import com.employees.employees.dto.EmployeeDTO;
import com.employees.employees.model.EmployeeModel;
import com.employees.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {


    public List<EmployeeDTO> getAll();

    public EmployeeDTO save(EmployeeDTO employeeDTO);

}
