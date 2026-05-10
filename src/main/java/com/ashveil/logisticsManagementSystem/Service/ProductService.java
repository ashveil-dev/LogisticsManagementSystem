package com.ashveil.logisticsManagementSystem.Service;

import com.ashveil.logisticsManagementSystem.Dto.Request.CreateProductRequestDto;
import com.ashveil.logisticsManagementSystem.Dto.Request.EditProductRequestDto;
import com.ashveil.logisticsManagementSystem.Entity.Product;
import com.ashveil.logisticsManagementSystem.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(CreateProductRequestDto dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();

        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product editProduct(Long id, EditProductRequestDto dto) {
        Product findProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("상품 없음"));

        String name = dto.getName();
        Integer price = dto.getPrice();
        Integer stock = dto.getStock();

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
