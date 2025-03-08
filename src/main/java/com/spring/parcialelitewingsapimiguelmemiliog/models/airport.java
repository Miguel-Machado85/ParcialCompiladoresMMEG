package com.spring.parcialelitewingsapimiguelmemiliog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "airport")
@Builder
public class airport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    @Column(unique = true, nullable=false)
    private String nombre;

    @Column(unique = true, nullable=false)
    private String direccion;

    @Column(unique = true, nullable=false)
    private int capacidad;

    @Column(unique = true, nullable=false)
    private String dueños="Sofia and Natalia the best owners";

}
