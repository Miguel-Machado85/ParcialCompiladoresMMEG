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
@Table(name = "Celebrities")
public class Celebrity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column()
    private String profession;

    @Column()
    private float net_worth;

    @Column()
    private boolean suspicious_activity = false;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<PrivateJet> jets;

    @OneToMany(mappedBy = "celebrity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Flights> flights;
}
