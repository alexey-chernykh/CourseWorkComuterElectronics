package com.example.courseworkcomputerelectronic.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name="videocards")
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic.entity")
public class Videocard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="company")
    private String company;
    @Column(name="memory_frequency")
    private Integer memoryFrequency;
    @Column(name="core_frequency")
    private Integer coreFrequency;
    @Column(name="memory_value")
    private Integer memoryValue;
    @Column(name="memory_bus")
    private Integer memoryBus;
    @Column(name="required_power")
    private Integer requiredPower;
    @Column(name="memory_type")
    private String memoryType;
    @Column(name="interface")
    private String interfaceName;
    @Column(name="connectors")
    private String connectors;
    @Column(name="extra_supply")
    private String extraSupply;
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
        return "videocards";
    }
}