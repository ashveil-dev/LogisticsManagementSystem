package com.ashveil.logisticsManagementSystem.Repository;

import com.ashveil.logisticsManagementSystem.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
