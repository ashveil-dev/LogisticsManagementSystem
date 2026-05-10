package com.ashveil.logisticsManagementSystem.Controller;

import com.ashveil.logisticsManagementSystem.Entity.Product;
import com.ashveil.logisticsManagementSystem.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @PostMapping("/product")
    public Product create(@RequestBody Product product) {
        
        return productRepository.save(product);
    }

    @GetMapping("/product")
    public Object getAll() {
        return productRepository.findAll();
    }
}
