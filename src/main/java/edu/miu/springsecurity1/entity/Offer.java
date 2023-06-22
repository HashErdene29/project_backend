package edu.miu.springsecurity1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq2")
    @SequenceGenerator(name = "seq2", initialValue = 3)
    private int id;

    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
