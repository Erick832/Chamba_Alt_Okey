package com.example.demo.entities;
import com.sun.jdi.connect.Connector;
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
    @Column(name="description")
    private String description;
    @Column(name="state")
    private String state;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private Employer employer;

    @OneToOne
    private Employment employment;

}
