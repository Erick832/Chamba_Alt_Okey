package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    private String nameEmployment;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
