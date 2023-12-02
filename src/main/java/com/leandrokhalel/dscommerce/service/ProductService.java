package com.leandrokhalel.dscommerce.service;

import com.leandrokhalel.dscommerce.api.ProductRequest;
import com.leandrokhalel.dscommerce.domain.Product;
import com.leandrokhalel.dscommerce.api.ProductResponse;
import com.leandrokhalel.dscommerce.repository.ProductRepository;
import com.leandrokhalel.dscommerce.service.exception.DatabaseException;
import com.leandrokhalel.dscommerce.service.exception.ResourceNotFoundException;
import com.leandrokhalel.dscommerce.controllers.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    public Page<ProductResponse> findAll(String name, Pageable pageable) {
        return productRepository.searchByName(name, pageable)
                .map(ProductMapper::fromProductToResponse);
    }

    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::fromProductToResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest dto) {
        try {
            Product product = productRepository.getReferenceById(id);
            ProductMapper.copyRequestToProduct(dto, product);

            return ProductMapper.fromProductToResponse(product);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

}
