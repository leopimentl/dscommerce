package com.leandrokhalel.dscommerce.domain.product;

public record ProductDetailData(
        String name,
        String description,
        Double price,
        String imgUrl) {

    public ProductDetailData(Product p) {
        this(p.getName(), p.getDescription(), p.getPrice(), p.getImgUrl());
    }
}
