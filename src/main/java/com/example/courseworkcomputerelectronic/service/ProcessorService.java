package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.entity.Motherboard;
import com.example.courseworkcomputerelectronic.repository.ProcessorRepository;
import com.example.courseworkcomputerelectronic.entity.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class ProcessorService {
    private final ProcessorRepository processorRepository;

    @Autowired
    public ProcessorService(ProcessorRepository processorRepository) {
        this.processorRepository = processorRepository;
    }

    public Processor findById(Long id) {
        return processorRepository.getOne(id);
    }

    public List<Processor> findAll() {
        return processorRepository.findAll();
    }
    public List<Processor> findByFullNameContaining(String fullName) {
        return processorRepository.findByFullNameContaining(fullName);
    }

    public Processor saveProcessor(Processor processor) {
        return processorRepository.save(processor);
    }

    public void deleteById(Long id) {
        processorRepository.deleteById(id);
    }
}
