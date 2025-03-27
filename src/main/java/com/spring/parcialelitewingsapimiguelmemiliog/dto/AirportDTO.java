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
