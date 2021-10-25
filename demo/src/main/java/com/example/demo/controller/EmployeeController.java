package com.example.demo.controller;

import com.example.demo.common.EntityDtoConverter;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.dto.UserRequest;
import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;
    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @PostMapping
    public ResponseEntity<EmployeeResponse>createEmployee(@RequestBody EmployeeRequest employeeRequest){
        Employee employee= employeeServices.createEmployee(employeeRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>>findAllEmployee(){
        List<Employee>employees= employeeServices.findAllEmployer();
        return new ResponseEntity<>(entityDtoConverter.convertEmployeesToDto(employees),HttpStatus.OK);
    }
    @DeleteMapping("/{idEmployee}")
    public void deleteEmployee(@PathVariable String idEmployee){
        employeeServices.deleteEmployee(Long.valueOf(idEmployee));
    }
    @PutMapping("/{idEmployee}")
    public ResponseEntity<EmployeeResponse>updateEmployee(@PathVariable Long idEmployee,@RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeServices.updateEmployee(idEmployee,employeeRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(employee),HttpStatus.OK);
    }
    @GetMapping("/login")
    public ResponseEntity<EmployeeResponse>loginEmployer(@RequestBody UserRequest userRequest){
        Employee employee= employeeServices.loginEmployee(userRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(employee),HttpStatus.OK);
    }
}
