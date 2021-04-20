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

    //Vi anvender ikke denne klasse, men vi benyttede den til at se om der var hul igennem.

    UserRepository userRep = new UserRepository();


    @GetMapping("userList")
    public String userList(Model model) {
        DBManager.getConnection();
        ArrayList<User> allUsers = userRep.showAllUsers();
        model.addAttribute("userList", allUsers);
        return "/userList";
    }
}