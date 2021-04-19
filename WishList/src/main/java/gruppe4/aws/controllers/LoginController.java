package gruppe4.aws.controllers;

import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    UserRepository userRepository = new UserRepository();

    @PostMapping("/login")
    public String submitLogin(@RequestParam(name = "accountName") String accountName, HttpServletRequest request) {
        DBManager.getConnection();
        if (userRepository.validateAccount(accountName) == true) {
            HttpSession session = request.getSession();
            session.setAttribute("accountName", accountName);
            return "redirect:/wishListHub";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){

        return "frontPage";
    }


}
