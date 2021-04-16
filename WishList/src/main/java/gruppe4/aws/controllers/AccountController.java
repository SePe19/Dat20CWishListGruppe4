package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AccountController {
  User user = new User("accountName", "name", "email");

  @GetMapping("/account")
  public String account(Model model) {
    model.addAttribute("user", user);
    return "account";
  }


}
