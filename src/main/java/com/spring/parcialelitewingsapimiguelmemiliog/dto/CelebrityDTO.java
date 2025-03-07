package com.spring.parcialelitewingsapimiguelmemiliog.dto;


import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDTO {

    private Long id;

    @NotBlank(message = "La celebridad debe tener nombre")
    private String name;

    @NotBlank(message = "La celebridad debe tener profesion")
    private String profession;

    private float net_worth;

    private boolean suspicious_activity;

    private List<PrivateJet> jets;
}
