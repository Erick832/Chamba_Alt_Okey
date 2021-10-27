package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="Employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="last_name")
    private String lastName;
    @Column(name="company_name")
    private String company;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name="email")
    private String email;
    @Column (name="password")
    private String password;

}
