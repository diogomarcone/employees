package com.employees.employees.service.serviceImpl;

import com.employees.employees.dto.EmployeeDTO;
import com.employees.employees.model.EmployeeModel;
import com.employees.employees.repository.EmployeeRepository;
import com.employees.employees.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeModel> employees = repository.findAll();
        return employees.stream().map(this::toDto).collect(toList());
    }


    public EmployeeDTO save(EmployeeDTO employeeDTO){
        EmployeeModel employeeModel = repository.save(EmployeeModel.convert(employeeDTO));
        return employeeDTO.convert(employeeModel);
    }



    private EmployeeDTO toDto(EmployeeModel employeeModel) {
       return EmployeeDTO.builder()
                .id(employeeModel.getId())
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname())
                .salary(employeeModel.getSalary())
                .build();
    }

}
