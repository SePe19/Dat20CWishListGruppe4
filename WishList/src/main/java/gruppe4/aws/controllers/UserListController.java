package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserListController {
  UserRepository userRep = new UserRepository();

  @GetMapping("userList")
    public String userList(Model model) {
      ArrayList<User> allUsers = userRep.getAllUsers();
      model.addAttribute("userList", allUsers);
      return "/account";
  }
}
