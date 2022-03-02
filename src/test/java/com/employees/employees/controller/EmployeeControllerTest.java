package com.employees.employees.controller;

import com.employees.employees.model.EmployeeModel;
import com.employees.employees.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static java.time.LocalDate.now;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @MockBean
    private EmployeeRepository repository;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    private EmployeeModel employeeModel;

    List<EmployeeModel> employeeModelList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        employeeModel = EmployeeModel.builder()
                .id(1L)
                .name("Diogo")
                .surname("Marcone")
                .salary(1500.00)
                .created_at(LocalDateTime.now())
                .build();

        employeeModelList.add(employeeModel);
    }

    @Test
    public void deveRetonarUmaLista_QuandoGetAllEmployees() throws Exception{
        when(repository.findAll()).thenReturn(employeeModelList);

        mvc.perform(get("/api/employee"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json("[{'id':1,'name':'Diogo','surname':'Marcone','salary':1500.0}]"));
    }

    @Test
    public void deveRetornarUmEmployee_QuandoCreateEmployee() throws Exception{
        when(repository.save(employeeModel)).thenReturn(employeeModel);

        mvc.perform(post("/api/employee"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
