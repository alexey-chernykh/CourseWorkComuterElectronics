package com.example.courseworkcomputerelectronic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic")
public class CourseWorkComputerElectronicApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseWorkComputerElectronicApplication.class, args);
    }

}
