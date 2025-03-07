package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateJetDTO {
    private Long id;

    @NotBlank(message = "The jet must have a model")
    private String model;

    @NotBlank(message = "The jet's capacity must be listed")
    private int capacity;

    private Long ownerId;
}
