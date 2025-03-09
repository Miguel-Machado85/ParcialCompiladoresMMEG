package com.spring.parcialelitewingsapimiguelmemiliog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "flights")
@Builder
public class Flights {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    private String departureAirport;

    private String arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    @OneToOne
    @JoinColumn(name = "celebrity_Id")
    private Celebrity celebrity;

    @OneToOne
    @JoinColumn(name = "jet_Id")
    private PrivateJet privateJet;
}
