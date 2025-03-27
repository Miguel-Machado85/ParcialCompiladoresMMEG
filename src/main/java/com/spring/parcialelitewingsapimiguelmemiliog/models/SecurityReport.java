package com.spring.parcialelitewingsapimiguelmemiliog.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "security_report")
@Builder
public class SecurityReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String reportedBy;

    @Column()
    private String description;

    @Column()
    private boolean isResolved= false;

    @OneToOne
    @JoinColumn(name = "flight_Id")
    private Flights flight;

    public SecurityReport() {
    }

    public static SecurityReport builder(){
        return new SecurityReport();
    }

    public SecurityReport build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public SecurityReport setId(Long id) {
        this.id = id;
        return this;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public SecurityReport setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SecurityReport setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public SecurityReport setResolved(boolean resolved) {
        isResolved = resolved;
        return this;
    }

    public Flights getFlight() {
        return flight;
    }

    public SecurityReport setFlight(Flights flight) {
        this.flight = flight;
        return this;
    }
}
