package com.spring.parcialelitewingsapimiguelmemiliog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;

    @Column()
    private String departureAirport;

    @Column()
    private String arrivalAirport;

    @Column()
    private String departureTime;

    @Column()
    private String arrivalTime;

    @ManyToOne
    @JoinColumn(name = "celebrity_Id")
    private Celebrity celebrity;

    @ManyToOne
    @JoinColumn(name = "jet_Id")
    private PrivateJet privateJet;

    @Enumerated(EnumType.STRING)
    private Purpose purpose;

    public enum Purpose{
        Business,
        Vacation,
        Suspicious;
    }

    @OneToOne(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private SecurityReport securityReport;
}
