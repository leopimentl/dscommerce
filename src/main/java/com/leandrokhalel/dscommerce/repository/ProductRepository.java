package com.leandrokhalel.dscommerce.repository;

import com.leandrokhalel.dscommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
