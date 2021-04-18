package gruppe4.aws.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginController {

    @PostMapping("/login")
    public String submitLogin(@RequestParam(name = "accountName") String accountName, HttpServletRequest request) {

        HttpSession session = request.getSession();

        session.setAttribute("accountName", accountName);

        return "redirect:/wishListHub";
    }
}
