package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.entity.Motherboard;
import com.example.courseworkcomputerelectronic.repository.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class MotherboardService {
    private final MotherboardRepository motherboardRepository;

    @Autowired
    public MotherboardService(MotherboardRepository motherboardRepository) {
        this.motherboardRepository = motherboardRepository;
    }

    public Motherboard findById(Long id) {
        return motherboardRepository.getOne(id);
    }


    public List<Motherboard> findAll() {
        return motherboardRepository.findAll();
    }
    public List<Motherboard> findByFullNameContaining(String fullName) {
        return motherboardRepository.findByFullNameContaining(fullName);
    }

    public Motherboard saveMotherboard(Motherboard motherboard) {
        return motherboardRepository.save(motherboard);
    }

    public void deleteById(Long id) {
        motherboardRepository.deleteById(id);
    }
}
