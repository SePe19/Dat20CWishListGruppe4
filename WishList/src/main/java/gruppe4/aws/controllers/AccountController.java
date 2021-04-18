package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AccountController {
  User user = new User("accountNameTestJoJo", "name", "email");
  UserRepository newUser = new UserRepository();

  @GetMapping("/account")
  public String account(@RequestParam("accountName") String accountName, Model model, HttpServletRequest request) {
    DBManager.getConnection();
    newUser.getAccount(accountName);
    HttpSession session = request.getSession();
    session.getAttribute(accountName);
    model.addAttribute("user", accountName);
    return "account";
  }

  @GetMapping("/register")
  public String register() {
    DBManager.getConnection();
    return "register";
  }


  @PostMapping("/doRegister")
  public String doRegister(@RequestParam("accountName") String accountName, @RequestParam("name") String name, @RequestParam("email") String email, HttpServletRequest request) {
    newUser.makeUser(accountName, name, email);
    HttpSession session = request.getSession();
    session.setAttribute("accountName", user);
    return "redirect:/account";
  }
}
