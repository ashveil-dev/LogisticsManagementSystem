package com.ashveil.logisticsManagementSystem.Controller;

import com.ashveil.logisticsManagementSystem.Dto.Request.EditProductRequestDto;
import com.ashveil.logisticsManagementSystem.Entity.Product;
import com.ashveil.logisticsManagementSystem.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/product/{id}")
    public Product edit(@PathVariable Long id, @RequestBody EditProductRequestDto request) {
        Product findProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("상품 없음"));

        String name = request.getName();
        Integer price = request.getPrice();
        Integer stock = request.getStock();

        if(name != null) {
            findProduct.setName(name);
        }

        if(price != null) {
            findProduct.setPrice(price);
        }

        if(stock != null) {
            findProduct.setStock(stock);
        }

        return productRepository.save(findProduct);
    }
}
