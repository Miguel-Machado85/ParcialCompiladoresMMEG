package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportDTO {
    private Long id;

    @NotBlank(message = "The airport must have a name")
    private String nombre;

    @NotBlank(message = "The airport's location must be stated")
    private String direccion;

    @NotBlank(message = "The airport's capacity must be stated")
    private int capacidad;

    private String dueños;
}
