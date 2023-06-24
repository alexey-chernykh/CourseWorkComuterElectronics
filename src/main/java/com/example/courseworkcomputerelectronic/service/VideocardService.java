package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.entity.Videocard;
import com.example.courseworkcomputerelectronic.repository.VideocardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class VideocardService {
    private final VideocardRepository videocardRepository;

    @Autowired
    public VideocardService(VideocardRepository videocardRepository) {
        this.videocardRepository = videocardRepository;
    }

    public Videocard findById(Long id) {
        return videocardRepository.getOne(id);
    }


    public List<Videocard> findAll() {
        return videocardRepository.findAll();
    }
    public List<Videocard> findByFullNameContaining(String fullName) {
        return videocardRepository.findByFullNameContaining(fullName);
    }

    public Videocard saveVideocard(Videocard videocard) {
        return videocardRepository.save(videocard);
    }

    public void deleteById(Long id) {
        videocardRepository.deleteById(id);
    }
}
