package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="Ability")
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ability;
}
