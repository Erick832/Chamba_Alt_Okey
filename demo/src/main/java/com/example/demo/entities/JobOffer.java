package com.example.demo.entities;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name="Job_Offer")
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobOfferId;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private Employer employer;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employment>employments;
}
