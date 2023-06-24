package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.entity.Power;
import com.example.courseworkcomputerelectronic.repository.PowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class PowerService {
    private final PowerRepository powerRepository;

    @Autowired
    public PowerService(PowerRepository powerRepository) {
        this.powerRepository = powerRepository;
    }

    public Power findById(Long id) {
        return powerRepository.getOne(id);
    }


    public List<Power> findAll() {
        return powerRepository.findAll();
    }
    public List<Power> findByFullNameContaining(String fullName) {
        return powerRepository.findByFullNameContaining(fullName);
    }

    public Power savePower(Power power) {
        return powerRepository.save(power);
    }

    public void deleteById(Long id) {
        powerRepository.deleteById(id);
    }
}
