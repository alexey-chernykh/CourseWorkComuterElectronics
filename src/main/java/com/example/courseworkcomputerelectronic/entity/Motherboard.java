package com.example.courseworkcomputerelectronic.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name="motherboards")
@EntityScan(basePackages = "com.example.courseworkcomputerelectronic.entity")
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="company")
    private String company;
    @Column(name="socket_name")
    private String socketName;
    @Column(name="chipset_name")
    private String chipsetName;
    @Column(name="ram_support")
    private String ramSupport;
    @Column(name="ram_slots")
    private Integer ramSlots;
    @Column(name="form_factor")
    private String formFactor;
    @Column(name="m2_count")
    private Integer m2Count;
    @Column(name="power_connector")
    private String powerConnector;
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
        return "motherboards";
    }
}