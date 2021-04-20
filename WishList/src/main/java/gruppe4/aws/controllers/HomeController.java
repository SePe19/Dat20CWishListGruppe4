package gruppe4.aws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/frontPage")
    public String frontPage() {
        return "frontPage.html";
    }

    @GetMapping("/wishListHub")
    public String wishListHub(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.getAttribute("accountName");
        return "wishListHub.html";
    }
}
