package com.example.courseworkcomputerelectronic.controller;

import com.example.courseworkcomputerelectronic.CheckAuth;
import com.example.courseworkcomputerelectronic.Password;
import com.example.courseworkcomputerelectronic.entity.Processor;
import com.example.courseworkcomputerelectronic.entity.Product;
import com.example.courseworkcomputerelectronic.entity.User;
import com.example.courseworkcomputerelectronic.service.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.controller"})
public class ProfileController {
    private UserService userService;
    private ProductService productService;
    private ProcessorService processorService;
    private MotherboardService motherboardService;
    private VideocardService videocardService;
    private RamService ramService;
    private SsdService ssdService;
    private HddService hddService;
    private PowerService powerService;
    public ProfileController(UserService userService,
                             ProductService productService,
                             ProcessorService processorService,
                             MotherboardService motherboardService,
                             VideocardService videocardService,
                             RamService ramService,
                             SsdService ssdService,
                             HddService hddService,
                             PowerService powerService) {
        this.userService = userService;
        this.productService = productService;
        this.processorService = processorService;
        this.motherboardService = motherboardService;
        this.videocardService = videocardService;
        this.ramService = ramService;
        this.ssdService = ssdService;
        this.hddService = hddService;
        this.powerService = powerService;
    }
    @GetMapping("/profile")
    public String profilePage(Model model){
        CheckAuth.getInstance().check(model);
        CheckAuth.getInstance().getUser(model, userService);
        return "profile";
    }
    @GetMapping("/change-password")
    public String changePasswordPage(Model model){
        CheckAuth.getInstance().check(model);
        CheckAuth.getInstance().getUser(model, userService);
        model.addAttribute("password", new Password());
        return "change-password";
    }
    @PostMapping("/password-confirmation")
    public String changePasswordSubmit(@ModelAttribute Password password, Model model){
        CheckAuth.getInstance().check(model);
        User user = CheckAuth.getInstance().getUserObj(model, userService);
        model.addAttribute("password", password);
        Boolean isCorrect = userService.passwordMatch(password.getCurrentP(), user);
        model.addAttribute("isCorrect", isCorrect);
        if (isCorrect){
            user.setPassword(userService.passwordEncode(password.getNewP()));
            userService.saveUser(user);
        }
        return "change-password-result";
    }
    @GetMapping("/wishlist")
    public String wishlistPage(Model model){
        CheckAuth.getInstance().check(model);
        Object products[] = new Object[CheckAuth.getInstance().getUserObj(model, userService).getProducts().size()];
        Object product_types[] = new Object[CheckAuth.getInstance().getUserObj(model, userService).getProducts().size()];
        for (int i = 0; i<products.length; i++) {
            switch (((Product)(CheckAuth.getInstance().getUserObj(model, userService).getProducts().toArray()[i])).getProductType()){
                case "processors":
                    products[i] = processorService.findById(((Product)(CheckAuth.getInstance().getUserObj(model, userService).getProducts().toArray()[i])).getProductId());
                    product_types[i] = "processors";
                    break;
                case "motherboards":
                    products[i] = motherboardService.findById(((Product)(CheckAuth.getInstance().getUserObj(model, userService).getProducts().toArray()[i])).getProductId());
                    product_types[i] = "motherboards";
                    break;
                case "videocards":
                    products[i] = videocardService.findById(((Product)(CheckAuth.getInstance().getUserObj(model, userService).getProducts().toArray()[i])).getProductId());
                    product_types[i] = "videocards";
                    break;
                case "ram":
                    products[i] = ramService.findById(((Product)(CheckAuth.getInstance().getUserObj(model, userService).getProducts().toArray()[i])).getProductId());
                    product_types[i] = "ram";
                    break;
                case "ssd":
                    products[i] = ssdService.findById(((Product)(CheckAuth.getInstance().getUserObj(model, userService).getProducts().toArray()[i])).getProductId());
                    product_types[i] = "ssd";
                    break;
                case "hdd":
                    products[i] = hddService.findById(((Product)(CheckAuth.getInstance().getUserObj(model, userService).getProducts().toArray()[i])).getProductId());
                    product_types[i] = "hdd";
                    break;
                case "power":
                    products[i] = powerService.findById(((Product)(CheckAuth.getInstance().getUserObj(model, userService).getProducts().toArray()[i])).getProductId());
                    product_types[i] = "power";
                    break;
            }
        }

        model.addAttribute("wishlist", products);
        model.addAttribute("types", product_types);
        return "wishlist";
    }
    @GetMapping("/wishlist-add/{id}/{type}")
    public String wishlistAdd(@PathVariable("id") Long id, @PathVariable("type") String type, Model model){
        CheckAuth.getInstance().check(model);
        productService.save(new Product(id, type));
        CheckAuth.getInstance().getUserObj(model, userService).getProducts().addAll(productService.findByProductIdAndProductType(id, type));
        userService.saveUser(CheckAuth.getInstance().getUserObj(model, userService));
        return "redirect:/wishlist";
    }
}
