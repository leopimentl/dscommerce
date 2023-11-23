package com.leandrokhalel.dscommerce.api;

public record ProductResponse(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl) {
}
