package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    User user = new User("accountName", "name", "email");
    UserRepository makeNewUser = new UserRepository();


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
    public String createRegister(@RequestParam("accountName") String accountName, @RequestParam("name") String name, @RequestParam("email") String email) {
        makeNewUser.makeUser(accountName, name, email);
        System.out.println(accountName + name + email);
        return "redirect:/account";
    }

}
