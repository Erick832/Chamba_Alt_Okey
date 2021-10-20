package com.example.demo.controller;

import com.example.demo.common.EntityDtoConverter;
import com.example.demo.dto.EmployerRequest;
import com.example.demo.dto.EmployerResponse;
import com.example.demo.entities.Employer;
import com.example.demo.services.EmployerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employers")
public class EmployerController {
    @Autowired
    private EmployerServices employerServices;
    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @PostMapping
    public ResponseEntity<EmployerResponse>createEmployer(@RequestBody EmployerRequest employerRequest){
        Employer employer=employerServices.createEmployer(employerRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(employer), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployerResponse>>findAllEmployer(){
        List<Employer>employers=employerServices.findAllEmployer();
        return new ResponseEntity<>(entityDtoConverter.convertEmployersToDto(employers),HttpStatus.OK);
    }
    @DeleteMapping("/{idEmployer}")
    public void deleteEmployer(@PathVariable String idEmployer){
        employerServices.deleteEmployer(Long.valueOf(idEmployer));
    }
    @PutMapping("/{idEmployer}")
    public ResponseEntity<EmployerResponse>updateEmployer(@PathVariable Long idEmployer,@RequestBody EmployerRequest employerRequest){
        Employer employer=employerServices.updateEmployer(idEmployer,employerRequest);
        return  new ResponseEntity<>(entityDtoConverter.convertEntityToDto(employer),HttpStatus.OK);
    }
}
