package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.entity.Motherboard;
import com.example.courseworkcomputerelectronic.entity.Processor;
import com.example.courseworkcomputerelectronic.service.ProcessorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class ProcessorController {
    private final ProcessorService processorService;
    @Autowired
    public ProcessorController(ProcessorService processorService) {
        this.processorService = processorService;
    }
    @GetMapping("/processors")
    public String findAll(Model model){
        List<Processor> processors = processorService.findAll();
        model.addAttribute("processors", processors);

        CheckAuth.getInstance().check(model);
        return "processor/processor-list";
    }
    @RequestMapping(value = "/processor-search", params = "submit")
    public ModelAndView search(@RequestParam String keyword, Model model) {
        List<Processor> result = processorService.findByFullNameContaining(keyword);
        ModelAndView mav = new ModelAndView("processor/processor-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @RequestMapping(value = "/processor-search", params = "cancel")
    public ModelAndView cancel(Model model) {
        List<Processor> result = processorService.findAll();
        ModelAndView mav = new ModelAndView("processor/processor-search-result");
        mav.addObject("result", result);
        CheckAuth.getInstance().check(model);
        return mav;
    }
    @GetMapping("/processor-details/{id}")
    public String detailsProcessorForm(@PathVariable("id") Long id, Model model){
        Processor processor = processorService.findById(id);
        model.addAttribute("processor", processor);
        CheckAuth.getInstance().check(model);
        return "processor/processor-details";
    }
    @GetMapping("/processor-info/{id}")
    public String infoProcessorForm(@PathVariable("id") Long id, Model model){
        Processor processor = processorService.findById(id);
        model.addAttribute("processor", processor);
        CheckAuth.getInstance().check(model);
        return "processor/processor-info";
    }
    @PostMapping("/processor-details/go-back")
    public String detailsProcessor(Processor processor){
        return "redirect:/processors";
    }
}
