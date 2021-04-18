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
  User user = new User("accountNameTest", "name", "email");
  UserRepository newUser = new UserRepository();

  @GetMapping("/account")
  public String account(Model model) {
    DBManager.getConnection();
    ArrayList<User> getUser = newUser.showAllUsers();
    model.addAttribute("user", getUser);
    return "account";
  }

  @GetMapping("/register")
  public String register() {
    DBManager.getConnection();
    return "register";
  }

  @RequestMapping("/register")
  public String requestRegister() {
    return "register";
  }

  @PostMapping("/doRegister")
  public String doRegister(@RequestParam("accountName") String accountName, HttpServletRequest request) {
    newUser.getAccount(accountName);
    HttpSession session = request.getSession();
    session.setAttribute("accountName", accountName);
    return "redirect:/account";
  }


}
