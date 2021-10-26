package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Employment")
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Name_Employment")
    private String name;
    @Column(name="Type_Employment")
    private String type;
}
