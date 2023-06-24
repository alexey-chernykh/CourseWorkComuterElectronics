package com.example.courseworkcomputerelectronic.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name="ssd")
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic.entity")
public class Ssd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="company")
    private String company;
    @Column(name="memory_value")
    private Integer memoryValue;
    @Column(name="read_speed")
    private Integer readSpeed;
    @Column(name="write_speed")
    private Integer writeSpeed;
    @Column(name="form_factor")
    private String formFactor;
    @Column(name="interface")
    private String interfaceName;
    @Column(name="cells_type")
    private String cellsType;
    @Column(name="rating")
    private Float rating;
    @Column(name="price")
    private Integer price;
    @Column(name="is_available")
    private Boolean isAvailable;
    @Column(name="image_name")
    private String imageName;
    @Override
    public String toString(){
        return "ssd";
    }
}