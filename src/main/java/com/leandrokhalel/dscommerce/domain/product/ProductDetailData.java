package com.leandrokhalel.dscommerce.domain.product;

public record ProductDetailData(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl) {

    public ProductDetailData(Product p) {
        this(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getImgUrl());
    }
}
