package com.example.courseworkcomputerelectronic.repository;

import com.example.courseworkcomputerelectronic.entity.Motherboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.repository"})
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
    List<Motherboard> findByFullNameContaining(String fullName);
}
