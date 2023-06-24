package com.example.courseworkcomputerelectronic.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name="ram")
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic.entity")
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="company")
    private String company;
    @Column(name="ram_value")
    private Integer ramValue;
    @Column(name="ram_frequency")
    private Integer ramFrequency;
    @Column(name="supply_voltage")
    private Float supplyVoltage;
    @Column(name="cooling")
    private String cooling;
    @Column(name="memory_type")
    private String memoryType;
    @Column(name="timings")
    private String timings;
    @Column(name="slats_count")
    private Integer slatsCount;
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
        return "ram";
    }
}