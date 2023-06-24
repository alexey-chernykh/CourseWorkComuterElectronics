package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.entity.Ram;
import com.example.courseworkcomputerelectronic.entity.Ssd;
import com.example.courseworkcomputerelectronic.service.SsdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class SsdController {
    private final SsdService ssdService;
    @Autowired
    public SsdController(SsdService ssdService) {
        this.ssdService = ssdService;
    }
    @GetMapping("/ssd")
    public String findAll(Model model){
        List<Ssd> ssds = ssdService.findAll();
        model.addAttribute("ssds", ssds);
        CheckAuth.getInstance().check(model);
        return "ssd/ssd-list";
    }
    @RequestMapping(value ="/ssd-search", params = "submit")
    public ModelAndView search(@RequestParam String keyword, Model model) {
        List<Ssd> result = ssdService.findByFullNameContaining(keyword);
        ModelAndView mav = new ModelAndView("ssd/ssd-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @RequestMapping(value = "/ssd-search", params = "cancel")
    public ModelAndView cancel(Model model) {
        List<Ssd> result = ssdService.findAll();
        ModelAndView mav = new ModelAndView("ssd/ssd-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @GetMapping("/ssd-details/{id}")
    public String detailsSsdForm(@PathVariable("id") Long id, Model model){
        Ssd ssd = ssdService.findById(id);
        model.addAttribute("ssd", ssd);
        CheckAuth.getInstance().check(model);
        return "ssd/ssd-details";
    }
    @GetMapping("/ssd-info/{id}")
    public String infoSsdForm(@PathVariable("id") Long id, Model model){
        Ssd ssd = ssdService.findById(id);
        model.addAttribute("ssd", ssd);
        CheckAuth.getInstance().check(model);
        return "ssd/ssd-info";
    }
    @PostMapping("/ssd-details/go-back")
    public String detailsSsd(Ssd ssd){
        return "redirect:/ssd";
    }
}
