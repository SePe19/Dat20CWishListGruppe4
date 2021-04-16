package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AccountController {
  User user = new User("accountNameTest", "name", "email");
  UserRepository newUser = new UserRepository();

  @GetMapping("/account")
  public String account(Model model) {
    DBManager.getConnection();
    model.addAttribute("user", user);
    return "account";
  }

  @GetMapping("/register")
  public String register() {
    DBManager.getConnection();
    return "register";
  }

  @GetMapping("/doRegister")
  public String doRegister(@RequestParam("accountName") String accountName, @RequestParam("name") String name, @RequestParam("email") String email) {
    newUser.createAccount(accountName, name, email);
    return "redirect:/account";
  }


}
