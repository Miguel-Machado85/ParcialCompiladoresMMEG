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

    public Flights() {
    }

    public static Flights builder(){
        return new Flights();
    }

    public Flights build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public Flights setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public Flights setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
        return this;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public Flights setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
        return this;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public Flights setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public Flights setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public Flights setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
        return this;
    }

    public PrivateJet getPrivateJet() {
        return privateJet;
    }

    public Flights setPrivateJet(PrivateJet privateJet) {
        this.privateJet = privateJet;
        return this;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public Flights setPurpose(Purpose purpose) {
        this.purpose = purpose;
        return this;
    }

    public SecurityReport getSecurityReport() {
        return securityReport;
    }

    public Flights setSecurityReport(SecurityReport securityReport) {
        this.securityReport = securityReport;
        return this;
    }
}
