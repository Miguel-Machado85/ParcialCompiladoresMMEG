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

    public Celebrity() {
    }

    public static Celebrity builder(){
        return new Celebrity();
    }

    public Celebrity build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public float getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(float net_worth) {
        this.net_worth = net_worth;
    }

    public boolean isSuspicious_activity() {
        return suspicious_activity;
    }

    public void setSuspicious_activity(boolean suspicious_activity) {
        this.suspicious_activity = suspicious_activity;
    }

    public List<PrivateJet> getJets() {
        return jets;
    }

    public void setJets(List<PrivateJet> jets) {
        this.jets = jets;
    }

    public List<Flights> getFlights() {
        return flights;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }



}
