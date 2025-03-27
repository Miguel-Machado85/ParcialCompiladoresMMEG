package com.spring.parcialelitewingsapimiguelmemiliog.dto;


import com.spring.parcialelitewingsapimiguelmemiliog.models.Flights;
import com.spring.parcialelitewingsapimiguelmemiliog.models.PrivateJet;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.List;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public float getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(float net_worth) {
        this.net_worth = net_worth;
    }

    public boolean isSuspicious_activity() {
        return suspicious_activity;
    }

    public void setSuspicious_activity(boolean suspicious_activity) {
        this.suspicious_activity = suspicious_activity;
    }
}
