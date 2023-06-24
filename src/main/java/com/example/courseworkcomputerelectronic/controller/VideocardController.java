package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.entity.Ssd;
import com.example.courseworkcomputerelectronic.entity.Videocard;
import com.example.courseworkcomputerelectronic.service.VideocardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class VideocardController {
    private final VideocardService videocardService;
    @Autowired
    public VideocardController(VideocardService videocardService) {
        this.videocardService = videocardService;
    }
    @GetMapping("/videocards")
    public String findAll(Model model){
        List<Videocard> videocards = videocardService.findAll();
        model.addAttribute("videocards", videocards);
        CheckAuth.getInstance().check(model);
        return "videocard/videocard-list";
    }
    @RequestMapping(value ="/videocard-search", params = "submit")
    public ModelAndView search(@RequestParam String keyword, Model model) {
        List<Videocard> result = videocardService.findByFullNameContaining(keyword);
        ModelAndView mav = new ModelAndView("videocard/videocard-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @RequestMapping(value = "/videocard-search", params = "cancel")
    public ModelAndView cancel(Model model) {
        List<Videocard> result = videocardService.findAll();
        ModelAndView mav = new ModelAndView("videocard/videocard-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @GetMapping("/videocard-details/{id}")
    public String detailsVideocardForm(@PathVariable("id") Long id, Model model){
        Videocard videocard = videocardService.findById(id);
        model.addAttribute("videocard", videocard);
        CheckAuth.getInstance().check(model);
        return "videocard/videocard-details";
    }
    @GetMapping("/videocard-info/{id}")
    public String infoVideocardForm(@PathVariable("id") Long id, Model model){
        Videocard videocard = videocardService.findById(id);
        model.addAttribute("videocard", videocard);
        CheckAuth.getInstance().check(model);
        return "videocard/videocard-info";
    }
    @PostMapping("/videocard-details/go-back")
    public String detailsVideocard(Videocard videocard){
        return "redirect:/videocards";
    }
}
