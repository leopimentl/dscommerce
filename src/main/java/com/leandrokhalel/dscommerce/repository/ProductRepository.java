package com.leandrokhalel.dscommerce.repository;

import com.leandrokhalel.dscommerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT obj from Product obj 
            WHERE UPPER(obj.name) 
            LIKE UPPER(CONCAT('%', :name, '%'))
            """)
    Page<Product> searchByName(String name, Pageable pageable);
}
