package com.example.courseworkcomputerelectronic.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name="products")
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic.entity")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_id")
    private Long productId;
    @Column(name="product_type")
    private String productType;

    public Product(Long productId, String productType) {
        this.productId = productId;
        this.productType = productType;
    }
    public Product() {
    }



}