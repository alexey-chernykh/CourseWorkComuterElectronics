package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.entity.Hdd;
import com.example.courseworkcomputerelectronic.entity.Processor;
import com.example.courseworkcomputerelectronic.service.HddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class HddController {
    private final HddService hddService;
    @Autowired
    public HddController(HddService hddService) {
        this.hddService = hddService;
    }
    @GetMapping("/hdd")
    public String findAll(Model model){
        List<Hdd> hdds = hddService.findAll();
        model.addAttribute("hdds", hdds);

        CheckAuth.getInstance().check(model);
        return "hdd/hdd-list";


    }
    @RequestMapping(value ="/hdd-search", params = "submit")
    public ModelAndView search(@RequestParam String keyword, Model model) {
        List<Hdd> result = hddService.findByFullNameContaining(keyword);
        ModelAndView mav = new ModelAndView("hdd/hdd-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @RequestMapping(value = "/hdd-search", params = "cancel")
    public ModelAndView cancel(Model model) {
        List<Hdd> result = hddService.findAll();
        ModelAndView mav = new ModelAndView("hdd/hdd-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @GetMapping("/hdd-details/{id}")
    public String detailsHddForm(@PathVariable("id") Long id, Model model){
        Hdd hdd = hddService.findById(id);
        model.addAttribute("hdd", hdd);
        CheckAuth.getInstance().check(model);
        return "hdd/hdd-details";
    }
    @GetMapping("/hdd-info/{id}")
    public String infoHddForm(@PathVariable("id") Long id, Model model){
        Hdd hdd = hddService.findById(id);
        model.addAttribute("hdd", hdd);
        CheckAuth.getInstance().check(model);
        return "hdd/hdd-info";
    }
    @PostMapping("/hdd-details/go-back")
    public String detailsHdd(Hdd hdd){
        return "redirect:/hdd";
    }
}
