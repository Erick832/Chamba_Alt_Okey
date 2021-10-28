package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idEmployee;
    private long idEmployer;
    private String message;
}
