package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.entity.Power;
import com.example.courseworkcomputerelectronic.entity.Ram;
import com.example.courseworkcomputerelectronic.service.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class RamController {
    private final RamService ramService;
    @Autowired
    public RamController(RamService ramService) {
        this.ramService = ramService;
    }
    @GetMapping("/ram")
    public String findAll(Model model){
        List<Ram> rams = ramService.findAll();
        model.addAttribute("rams", rams);
        CheckAuth.getInstance().check(model);
        return "ram/ram-list";
    }
    @RequestMapping(value ="/ram-search", params = "submit")
    public ModelAndView search(@RequestParam String keyword, Model model) {
        List<Ram> result = ramService.findByFullNameContaining(keyword);
        ModelAndView mav = new ModelAndView("ram/ram-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @RequestMapping(value = "/ram-search", params = "cancel")
    public ModelAndView cancel(Model model) {
        List<Ram> result = ramService.findAll();
        ModelAndView mav = new ModelAndView("ram/ram-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @GetMapping("/ram-details/{id}")
    public String detailsRamForm(@PathVariable("id") Long id, Model model){
        Ram ram = ramService.findById(id);
        model.addAttribute("ram", ram);
        CheckAuth.getInstance().check(model);
        return "ram/ram-details";
    }
    @GetMapping("/ram-info/{id}")
    public String infoRamForm(@PathVariable("id") Long id, Model model){
        Ram ram = ramService.findById(id);
        model.addAttribute("ram", ram);
        CheckAuth.getInstance().check(model);
        return "ram/ram-info";
    }
    @PostMapping("/ram-details/go-back")
    public String detailsRam(Ram ram){
        return "redirect:/ram";
    }
}
