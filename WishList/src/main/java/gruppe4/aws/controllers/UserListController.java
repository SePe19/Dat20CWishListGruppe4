package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class UserListController {
    DBManager dbManager = new DBManager();
    UserRepository userRep = new UserRepository();


    @GetMapping("userList")
    public String userList(Model model) {
        DBManager.getConnection();
        ArrayList<User> allUsers = userRep.showAllUsers();
        model.addAttribute("userList", allUsers);
        return "/userList";
    }

    @GetMapping("/registerList")
    public String register() {
        dbManager.getConnection();
        return "/registerList";
    }

    @PostMapping("/doRegisterList")
    public String createRegister(@RequestParam("accountName") String accountName, @RequestParam("name") String name, @RequestParam("email") String email) {
        userRep.makeUser(accountName, name, email);
        return "redirect:/userList";
    }
}