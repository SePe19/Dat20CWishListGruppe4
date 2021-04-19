package gruppe4.aws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/frontPage")
    public String frontPage() {
        return "frontPage.html";
    }

    @GetMapping("/wishListHub")
    public String wishListHub() {
        return "wishListHub.html";
    }
}
