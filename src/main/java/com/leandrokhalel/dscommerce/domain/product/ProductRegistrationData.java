package com.leandrokhalel.dscommerce.domain.product;



public record ProductRegistrationData(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl) {
}
