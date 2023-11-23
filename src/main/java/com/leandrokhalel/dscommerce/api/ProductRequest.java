package com.leandrokhalel.dscommerce.api;



public record ProductRequest(
        String name,
        String description,
        Double price,
        String imgUrl) {
}
