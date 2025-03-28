package com.spring.parcialelitewingsapimiguelmemiliog.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PrivateJetDTO {
    private Long id;

    @NotBlank(message = "The jet must have a model")
    private String model;

    @NotNull(message = "The jet's capacity must be listed")
    @Min(1)
    private int capacity;

    private Long ownerId;

    public PrivateJetDTO(Long id, String model, int capacity, Long ownerId) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
        this.ownerId = ownerId;
    }

    public PrivateJetDTO() {
    }

    public static PrivateJetDTO builder(){
        return new PrivateJetDTO();
    }

    public PrivateJetDTO build(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
