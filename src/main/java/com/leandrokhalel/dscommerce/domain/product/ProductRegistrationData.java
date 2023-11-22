package com.leandrokhalel.dscommerce.domain.product;



public record ProductRegistrationData(
        String name,
        String description,
        Double price,
        String imgUrl) {
}
