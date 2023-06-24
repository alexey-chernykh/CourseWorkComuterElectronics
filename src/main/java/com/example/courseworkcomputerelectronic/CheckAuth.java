package com.example.courseworkcomputerelectronic;

import com.example.courseworkcomputerelectronic.entity.User;
import com.example.courseworkcomputerelectronic.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public final class CheckAuth {
    private static CheckAuth instance;

    private CheckAuth() {

    }
    public static CheckAuth getInstance() {
        if (instance == null) {
            instance = new CheckAuth();
        }
        return instance;
    }
    public void check(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName().split("@")[0];
            model.addAttribute("username", currentUserName);
        }else{
            model.addAttribute("username", "My Profile");
        }
    }

    public void getUser(Model model, UserService userService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String email = authentication.getName();
            model.addAttribute("user", userService.findByEmail(email));
        }
    }
    public User getUserObj(Model model, UserService userService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String email = authentication.getName();
            return userService.findByEmail(email);
        }return null;
    }
}
