package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repository.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserListController {
  DBManager mysqlRep = new DBManager();

  @GetMapping("userList")
    public String userList(Model model) {
    DBManager.getConnection();
      ArrayList<User> allUsers = mysqlRep.showAllUsers();
      model.addAttribute("userList", allUsers);
      return "/account";
  }
}
