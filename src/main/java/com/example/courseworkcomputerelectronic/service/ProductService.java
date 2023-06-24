package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.entity.Product;
import com.example.courseworkcomputerelectronic.entity.Ssd;
import com.example.courseworkcomputerelectronic.repository.ProductRepository;
import com.example.courseworkcomputerelectronic.repository.SsdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product findById(Long id) {
        return productRepository.getOne(id);
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByProductIdAndProductType(Long id, String type) {
        return productRepository.findByProductIdAndProductType(id, type);
    }
}
