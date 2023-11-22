package com.leandrokhalel.dscommerce.api;



public record ProductRegistrationData(
        String name,
        String description,
        Double price,
        String imgUrl) {
}
