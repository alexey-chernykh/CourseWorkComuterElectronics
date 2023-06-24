package com.example.courseworkcomputerelectronic.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name="hdd")
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic.entity")
public class Hdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="company")
    private String company;
    @Column(name="memory_value")
    private Integer memoryValue;
    @Column(name="form_factor")
    private String formFactor;
    @Column(name="interface")
    private String interfaceName;
    @Column(name="spindle_speed")
    private Integer spindleSpeed;
    @Column(name="buffer_value")
    private Integer bufferValue;
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
        return "hdd";
    }

}