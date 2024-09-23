package com.avhsek.e_commerce_backend.controller;

import com.avhsek.e_commerce_backend.entity.Product;
import com.avhsek.e_commerce_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public g

}
