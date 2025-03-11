package com.spring.parcialelitewingsapimiguelmemiliog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "privateJet", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Flights> flight;

}
