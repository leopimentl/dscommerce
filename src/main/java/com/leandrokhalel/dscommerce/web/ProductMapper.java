package com.leandrokhalel.dscommerce.web;

import com.leandrokhalel.dscommerce.api.ProductRequest;
import com.leandrokhalel.dscommerce.api.ProductResponse;
import com.leandrokhalel.dscommerce.domain.Product;

public class ProductMapper {
    public static ProductResponse fromProductToResponse(Product product){
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl());
    }

    public static Product copyRequestToProduct(ProductRequest request, Product product) {
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setImgUrl(request.imgUrl());

        return product;
    }
}
