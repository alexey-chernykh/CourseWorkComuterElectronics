package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.entity.Hdd;
import com.example.courseworkcomputerelectronic.repository.HddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class HddService {
    private final HddRepository hddRepository;

    @Autowired
    public HddService(HddRepository hddRepository) {
        this.hddRepository = hddRepository;
    }

    public Hdd findById(Long id) {
        return hddRepository.getOne(id);
    }


    public List<Hdd> findAll() {
        return hddRepository.findAll();
    }
    public List<Hdd> findByFullNameContaining(String fullName) {
        return hddRepository.findByFullNameContaining(fullName);
    }

    public Hdd saveHdd(Hdd hdd) {
        return hddRepository.save(hdd);
    }

    public void deleteById(Long id) {
        hddRepository.deleteById(id);
    }
}
