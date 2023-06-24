package com.example.courseworkcomputerelectronic.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name="power")
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic.entity")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="company")
    private String company;
    @Column(name="capacity")
    private Integer capacity;
    @Column(name="power_connectors")
    private String powerConnectors;
    @Column(name="sata_connectors")
    private String sataConnectors;
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
        return "power";
    }
}