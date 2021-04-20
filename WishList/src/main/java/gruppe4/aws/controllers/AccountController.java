package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    UserRepository newUser = new UserRepository();

    @GetMapping("/account")
    public String account(Model model, HttpServletRequest request) {
        DBManager.getConnection();
        HttpSession session = request.getSession();
        String accountName = (String) session.getAttribute("accountName");

        User currentUser = newUser.getAccount(accountName);
        if(currentUser == null)
            return "redirect:/login";

        model.addAttribute("user", currentUser);
        return "account";
    }
    @GetMapping("/register")
    public String register() {
        DBManager.getConnection();
        return "registerAccount";
    }

    @PostMapping("/doRegister")
    public String doRegister(@RequestParam("accountName") String accountName, @RequestParam("name") String name, @RequestParam("email") String email, HttpServletRequest request) {
        DBManager.getConnection();
        newUser.makeUser(accountName, name, email);
        HttpSession session = request.getSession();
        session.setAttribute("accountName", accountName);
        return "redirect:/account?accountName=" + accountName;
    }
    @PostMapping("/deleteAccount")
    public String deleteWish(@RequestParam("accountName")String accountName){
        newUser.deleteUser(accountName);
        return "redirect:/account";
    }
}
