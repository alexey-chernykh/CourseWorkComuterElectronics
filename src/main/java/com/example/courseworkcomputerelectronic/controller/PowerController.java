package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.entity.Motherboard;
import com.example.courseworkcomputerelectronic.entity.Power;
import com.example.courseworkcomputerelectronic.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class PowerController {
    private final PowerService powerService;
    @Autowired
    public PowerController(PowerService powerService) {
        this.powerService = powerService;
    }
    @GetMapping("/power")
    public String findAll(Model model){
        List<Power> powers = powerService.findAll();
        model.addAttribute("powers", powers);
        CheckAuth.getInstance().check(model);
        return "power/power-list";
    }
    @RequestMapping(value ="/power-search", params = "submit")
    public ModelAndView search(@RequestParam String keyword, Model model) {
        List<Power> result = powerService.findByFullNameContaining(keyword);
        ModelAndView mav = new ModelAndView("power/power-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @RequestMapping(value = "/power-search", params = "cancel")
    public ModelAndView cancel(Model model) {
        List<Power> result = powerService.findAll();
        ModelAndView mav = new ModelAndView("power/power-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @GetMapping("/power-details/{id}")
    public String detailsPowerForm(@PathVariable("id") Long id, Model model){
        Power power = powerService.findById(id);
        model.addAttribute("power", power);
        CheckAuth.getInstance().check(model);
        return "power/power-details";
    }
    @GetMapping("/power-info/{id}")
    public String infoPowerForm(@PathVariable("id") Long id, Model model){
        Power power = powerService.findById(id);
        model.addAttribute("power", power);
        CheckAuth.getInstance().check(model);
        return "power/power-info";
    }
    @PostMapping("/power-details/go-back")
    public String detailsPower(Power power){
        return "redirect:/power";
    }
}
