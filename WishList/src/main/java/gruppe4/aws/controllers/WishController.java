package gruppe4.aws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishController {

    @GetMapping("/Wish")
    public String wish(Model model) {
        return "/wish";
    }

    @GetMapping("/registerWish")
    public String register(){

        return "registerWish";
    }
}


