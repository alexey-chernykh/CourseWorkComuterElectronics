package com.example.courseworkcomputerelectronic.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name="processors")
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic.entity")
public class Processor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="company")
    private String company;
    @Column(name="socket_name")
    private String socketName;
    @Column(name="cores")
    private Integer cores;
    @Column(name="threads")
    private Integer threads;
    @Column(name="frequency")
    private Integer frequency;
    @Column(name="max_frequency")
    private Integer maxFrequency;
    @Column(name="tech_process")
    private Integer techProcess;
    @Column(name="tdp")
    private Integer tdp;
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
        return "processors";
    }
}