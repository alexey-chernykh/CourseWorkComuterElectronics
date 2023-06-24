package com.example.courseworkcomputerelectronic.repository;

import com.example.courseworkcomputerelectronic.entity.Ram;
import com.example.courseworkcomputerelectronic.entity.Videocard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.repository"})
public interface RamRepository extends JpaRepository<Ram, Long> {
    List<Ram> findByFullNameContaining(String fullName);
}
