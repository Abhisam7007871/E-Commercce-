package com.avhsek.e_commerce_backend.repository;

import com.avhsek.e_commerce_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
