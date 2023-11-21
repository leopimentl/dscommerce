package com.leandrokhalel.dscommerce.service;

import com.leandrokhalel.dscommerce.domain.product.Product;
import com.leandrokhalel.dscommerce.domain.product.ProductDetailData;
import com.leandrokhalel.dscommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<ProductDetailData> findAll(Pageable pageable) {
        Page<Product> resources = productRepository.findAll(pageable);
        return resources.map(ProductDetailData::new);
    }
}
