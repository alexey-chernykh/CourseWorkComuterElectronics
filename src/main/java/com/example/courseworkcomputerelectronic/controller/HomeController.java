package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.UserRegistrationDto;
import com.example.courseworkcomputerelectronic.entity.User;
import com.example.courseworkcomputerelectronic.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class HomeController {
    private UserService userService;
    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String Index(){
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String Index(Model model){
        CheckAuth.getInstance().check(model);
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "registration";
    }
    @PostMapping("/registration/save")
    public String registration(@ModelAttribute("user") UserRegistrationDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
