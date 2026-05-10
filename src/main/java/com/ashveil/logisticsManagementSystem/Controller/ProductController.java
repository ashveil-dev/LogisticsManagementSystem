package com.ashveil.logisticsManagementSystem.Controller;

import com.ashveil.logisticsManagementSystem.Dto.Request.CreateProductRequestDto;
import com.ashveil.logisticsManagementSystem.Dto.Request.EditProductRequestDto;
import com.ashveil.logisticsManagementSystem.Entity.Product;
import com.ashveil.logisticsManagementSystem.Repository.ProductRepository;
import com.ashveil.logisticsManagementSystem.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public Product create(@RequestBody CreateProductRequestDto dto) {
        return productService.create(dto);

    }

    @GetMapping("/product")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PutMapping("/product/{id}")
    public Product edit(@PathVariable Long id, @RequestBody EditProductRequestDto dto) {
        return productService.editProduct(id, dto);
    }
}
