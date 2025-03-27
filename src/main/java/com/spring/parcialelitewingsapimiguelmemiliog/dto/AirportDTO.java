package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor

public class AirportDTO {
    private Long id;

    @NotBlank(message = "The airport must have a name")
    private String nombre;

    @NotBlank(message = "The airport's location must be stated")
    private String direccion;

    @NotBlank(message = "The airport's capacity must be stated")
    private int capacidad;

    private String dueños;


    public AirportDTO(){

    }

    public static AirportDTO builder(){
        return new AirportDTO();
    }

    public AirportDTO build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public AirportDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public AirportDTO setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public AirportDTO setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public AirportDTO setCapacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public String getDueños() {
        return dueños;
    }

    public AirportDTO setDueños(String dueños) {
        this.dueños = dueños;
        return this;
    }
}
