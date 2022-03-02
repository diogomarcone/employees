package com.employees.employees.dto;

import com.employees.employees.model.EmployeeModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDTO {

    private Long id;
    private String name;
    private String surname;
    private Double salary;


    public static EmployeeDTO convert(EmployeeModel employeeModel){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeeModel.getId());
        employeeDTO.setName(employeeModel.getName());
        employeeDTO.setSurname(employeeModel.getSurname());
        employeeDTO.setSalary(employeeModel.getSalary());

        return employeeDTO;
    }
}

