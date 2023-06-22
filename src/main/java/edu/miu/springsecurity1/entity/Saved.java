package edu.miu.springsecurity1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Saved {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq3")
    @SequenceGenerator(name = "seq3", initialValue = 2)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
