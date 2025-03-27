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
public class airport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable=false)
    private String nombre;

    @Column(unique = true, nullable=false)
    private String direccion;

    @Column(unique = true, nullable=false)
    private int capacidad;

    @Column(unique = true, nullable=false)
    private String dueños="Sofia and Natalia the best owners";

    public airport() {
    }

    public static airport builder(){
        return new airport();
    }

    public airport build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDueños() {
        return dueños;
    }

    public void setDueños(String dueños) {
        this.dueños = dueños;
    }
}
