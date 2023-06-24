package com.example.courseworkcomputerelectronic.repository;

import com.example.courseworkcomputerelectronic.entity.Product;
import com.example.courseworkcomputerelectronic.entity.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.repository"})
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select u from Product u where u.productId = ?1 and u.productType = ?2")
    public List<Product> findByProductIdAndProductType(Long id, String type);
}
