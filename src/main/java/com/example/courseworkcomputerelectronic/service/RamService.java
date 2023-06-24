package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.entity.Ram;
import com.example.courseworkcomputerelectronic.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class RamService {
    private final RamRepository ramRepository;

    @Autowired
    public RamService(RamRepository ramRepository) {
        this.ramRepository = ramRepository;
    }

    public Ram findById(Long id) {
        return ramRepository.getOne(id);
    }


    public List<Ram> findAll() {
        return ramRepository.findAll();
    }
    public List<Ram> findByFullNameContaining(String fullName) {
        return ramRepository.findByFullNameContaining(fullName);
    }

    public Ram saveRam(Ram ram) {
        return ramRepository.save(ram);
    }

    public void deleteById(Long id) {
        ramRepository.deleteById(id);
    }
}
