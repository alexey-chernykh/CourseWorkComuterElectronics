package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.entity.Ssd;
import com.example.courseworkcomputerelectronic.repository.SsdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class SsdService {
    private final SsdRepository ssdRepository;

    @Autowired
    public SsdService(SsdRepository ssdRepository) {
        this.ssdRepository = ssdRepository;
    }

    public Ssd findById(Long id) {
        return ssdRepository.getOne(id);
    }


    public List<Ssd> findAll() {
        return ssdRepository.findAll();
    }
    public List<Ssd> findByFullNameContaining(String fullName) {
        return ssdRepository.findByFullNameContaining(fullName);
    }

    public Ssd saveSsd(Ssd ssd) {
        return ssdRepository.save(ssd);
    }

    public void deleteById(Long id) {
        ssdRepository.deleteById(id);
    }
}
