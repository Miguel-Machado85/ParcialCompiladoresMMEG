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
    @JoinColumn(name = "jet_Id")
    private PrivateJet privateJet;

}
