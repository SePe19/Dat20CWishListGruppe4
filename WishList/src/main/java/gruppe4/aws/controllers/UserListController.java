package gruppe4.aws.controllers;

import gruppe4.aws.managers.DBManager;
import gruppe4.aws.models.User;
//import gruppe4.aws.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.util.ArrayList;

@Controller
public class UserListController {
  //UserRepository userRep = new UserRepository();
  DBManager dbManager = new DBManager();

  @GetMapping("userList")
    public String userList(Model model) {
      DBManager.getConnection();
      ArrayList<User> allUsers = dbManager.getAllUsers();
      model.addAttribute("userList", allUsers);
      return "/account";
  }
}
