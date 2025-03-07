package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportDTO {
    private String id;

    private String nombre;

    private String direccion;

    private int capacidad;

    private String dueños;
}
