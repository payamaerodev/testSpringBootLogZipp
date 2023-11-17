package com.example.test.repository;

import com.example.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "CALL GetAllProducts();", nativeQuery = true)
    List<Product> getProductsByStoredProcedure();
}
