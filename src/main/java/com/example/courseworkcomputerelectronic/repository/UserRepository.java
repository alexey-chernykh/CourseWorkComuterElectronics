package com.example.courseworkcomputerelectronic.repository;

import com.example.courseworkcomputerelectronic.UserRegistrationDto;
import com.example.courseworkcomputerelectronic.entity.Hdd;
import com.example.courseworkcomputerelectronic.entity.Product;
import com.example.courseworkcomputerelectronic.entity.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.repository"})
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
