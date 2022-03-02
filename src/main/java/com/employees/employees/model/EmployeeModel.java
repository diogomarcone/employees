package com.employees.employees.model;

import com.employees.employees.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employees")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Double salary;

    private LocalDateTime created_at;

    private LocalDate updated_at;

    @PrePersist
    private void prePersist(){
        created_at = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }


    public static EmployeeModel convert(EmployeeDTO employeeDTO){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employeeDTO.getId());
        employeeModel.setName(employeeDTO.getName());
        employeeModel.setSurname(employeeDTO.getSurname());
        employeeModel.setSalary(employeeDTO.getSalary());

        return employeeModel;
    }


}
