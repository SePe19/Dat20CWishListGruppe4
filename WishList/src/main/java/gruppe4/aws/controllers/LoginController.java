package gruppe4.aws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String submitLogin(@RequestParam(name = "accountName") String accountName, HttpServletRequest request) {

        HttpSession session = request.getSession();

        session.setAttribute("accountName", accountName);

        return "redirect:/wishListHub";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}