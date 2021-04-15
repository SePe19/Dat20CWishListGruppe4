package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repository.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    DBManager makeNewUser = new DBManager();

    private User user;

    public UserController() {
        this.user = new User("accountName", "name", "email");
    }

    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("user", user);
        return "/account";
    }

    @GetMapping("/register")
    public String register() {
        DBManager.getConnection();
        return "/register";
    }

    @PostMapping("/createRegister")
    public String createRegister(@ModelAttribute User model) {
        makeNewUser.makeUser();
        this.user = model;
        return "redirect:/account";
    }

}
