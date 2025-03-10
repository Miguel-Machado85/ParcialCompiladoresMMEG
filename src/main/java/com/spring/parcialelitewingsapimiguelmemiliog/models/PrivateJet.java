package com.spring.parcialelitewingsapimiguelmemiliog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "Jets")
public class PrivateJet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String model;

    @Column()
    private int capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Celebrity owner;

    @OneToOne(mappedBy = "privateJet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Flights flight;

    @OneToOne(mappedBy = "privateJet", cascade = CascadeType.ALL, orphanRemoval = true)
    private SecurityReport securityReport;
}
