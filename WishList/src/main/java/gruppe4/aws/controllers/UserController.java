package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private User user;

    public UserController() {
        this.user = new User("name", "email");
    }

    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("user", user);
        return "/account";
    }

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @PostMapping("/createRegister")
    public String createRegister(@ModelAttribute User model) {
        this.user = model;
        return "redirect:/account";
    }

}
