package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.entity.Hdd;
import com.example.courseworkcomputerelectronic.entity.Motherboard;
import com.example.courseworkcomputerelectronic.entity.Processor;
import com.example.courseworkcomputerelectronic.service.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class MotherboardController {
    private final MotherboardService motherboardService;
    @Autowired
    public MotherboardController(MotherboardService motherboardService) {
        this.motherboardService = motherboardService;
    }
    @GetMapping("/motherboards")
    public String findAll(Model model){
        List<Motherboard> motherboards = motherboardService.findAll();
        model.addAttribute("motherboards", motherboards);
        CheckAuth.getInstance().check(model);
        return "motherboard/motherboard-list";
    }
    @RequestMapping(value ="/motherboard-search", params = "submit")
    public ModelAndView search(@RequestParam String keyword, Model model) {
        List<Motherboard> result = motherboardService.findByFullNameContaining(keyword);
        ModelAndView mav = new ModelAndView("motherboard/motherboard-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @RequestMapping(value = "/motherboard-search", params = "cancel")
    public ModelAndView cancel(Model model) {
        List<Motherboard> result = motherboardService.findAll();
        ModelAndView mav = new ModelAndView("motherboard/motherboard-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @GetMapping("/motherboard-details/{id}")
    public String detailsMotherboardForm(@PathVariable("id") Long id, Model model){
        Motherboard motherboard = motherboardService.findById(id);
        model.addAttribute("motherboard", motherboard);
        CheckAuth.getInstance().check(model);
        return "motherboard/motherboard-details";
    }
    @GetMapping("/motherboard-info/{id}")
    public String infoMotherboardForm(@PathVariable("id") Long id, Model model){
        Motherboard motherboard = motherboardService.findById(id);
        model.addAttribute("motherboard", motherboard);
        CheckAuth.getInstance().check(model);
        return "motherboard/motherboard-info";
    }
    @PostMapping("/motherboard-details/go-back")
    public String detailsMotherboard(Motherboard motherboard){
        return "redirect:/motherboards";
    }
}
