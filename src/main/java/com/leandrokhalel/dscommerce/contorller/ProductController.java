package com.leandrokhalel.dscommerce.contorller;

import com.leandrokhalel.dscommerce.domain.product.ProductDetailData;
import com.leandrokhalel.dscommerce.domain.product.ProductRegistrationData;
import com.leandrokhalel.dscommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDetailData>> findAll(ProductRegistrationData data, Pageable pageable) {
        var resources = productService.findAll(pageable);
        return ResponseEntity.ok(resources);
    }
}
