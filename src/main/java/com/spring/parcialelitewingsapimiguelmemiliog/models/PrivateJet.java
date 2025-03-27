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

    public PrivateJet() {
    }

    public static PrivateJet builder(){
        return new PrivateJet();
    }

    public PrivateJet build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Celebrity getOwner() {
        return owner;
    }

    public void setOwner(Celebrity owner) {
        this.owner = owner;
    }

    public List<Flights> getFlight() {
        return flight;
    }

    public void setFlight(List<Flights> flight) {
        this.flight = flight;
    }
}
