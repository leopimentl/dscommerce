package com.leandrokhalel.dscommerce.api;

import com.leandrokhalel.dscommerce.domain.Product;

public record ProductDetailData(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl) {
}
