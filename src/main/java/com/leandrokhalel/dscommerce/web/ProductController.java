package com.leandrokhalel.dscommerce.web;

import com.leandrokhalel.dscommerce.api.ProductDetailData;
import com.leandrokhalel.dscommerce.api.ProductRegistrationData;
import com.leandrokhalel.dscommerce.domain.Product;
import com.leandrokhalel.dscommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDetailData>> findAll(Pageable pageable) {
        Page<ProductDetailData> resources = productService.findAll(pageable).map(ProductMapper::fromProductToDetailData);
        return ResponseEntity.ok(resources);
    }

    @PostMapping
    public ResponseEntity<ProductDetailData> insert(@RequestBody ProductRegistrationData data) {
        Product product = productService.insert(data);
        ProductDetailData response = ProductMapper.fromProductToDetailData(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }
}
