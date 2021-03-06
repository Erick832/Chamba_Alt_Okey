package com.example.demo.dto;

import com.example.demo.entities.Ability;
import com.example.demo.entities.Employment;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private List<Ability>abilities;
    private Employment employment;


}
