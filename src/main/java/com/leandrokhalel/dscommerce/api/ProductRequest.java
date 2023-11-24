package com.leandrokhalel.dscommerce.api;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @Size(min = 3, max = 80)
        @NotBlank
        String name,
        String description,
        @Positive
        Double price,
        String imgUrl) {
}
