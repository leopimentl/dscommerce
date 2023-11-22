package com.leandrokhalel.dscommerce.service;

import com.leandrokhalel.dscommerce.domain.Product;
import com.leandrokhalel.dscommerce.api.ProductDetailData;
import com.leandrokhalel.dscommerce.api.ProductRegistrationData;
import com.leandrokhalel.dscommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product insert(ProductRegistrationData data) {
        var product = new Product();
        product.setName(data.name());
        product.setDescription(data.description());
        product.setPrice(data.price());
        product.setImgUrl(data.imgUrl());
        return productRepository.save(product);
    }
}
