package com.example.courseworkcomputerelectronic.repository;

import com.example.courseworkcomputerelectronic.entity.Motherboard;
import com.example.courseworkcomputerelectronic.entity.Videocard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.repository"})
public interface VideocardRepository extends JpaRepository<Videocard, Long> {
    List<Videocard> findByFullNameContaining(String fullName);
}
