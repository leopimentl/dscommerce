package com.leandrokhalel.dscommerce.service;

import com.leandrokhalel.dscommerce.api.ProductRequest;
import com.leandrokhalel.dscommerce.domain.Product;
import com.leandrokhalel.dscommerce.api.ProductResponse;
import com.leandrokhalel.dscommerce.repository.ProductRepository;
import com.leandrokhalel.dscommerce.web.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductResponse insert(ProductRequest dto) {
        Product product = new Product();
        ProductMapper.copyRequestToProduct(dto, product);
        productRepository.save(product);

        return ProductMapper.fromProductToResponse(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductMapper::fromProductToResponse);
    }

    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::fromProductToResponse)
                .get();
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest dto) {
        Product product = productRepository.getReferenceById(id);
        ProductMapper.copyRequestToProduct(dto, product);

        return ProductMapper.fromProductToResponse(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
