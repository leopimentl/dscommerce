package com.leandrokhalel.dscommerce.web;

import com.leandrokhalel.dscommerce.api.ProductDetailData;
import com.leandrokhalel.dscommerce.domain.Product;

public class ProductMapper {
    public static ProductDetailData fromProductToDetailData(Product product){
        return new ProductDetailData(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl());
    }
}
