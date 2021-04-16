package gruppe4.aws.controllers;

import gruppe4.aws.models.Wish;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishController {
    Wish wish = new Wish("", "", "", 0, 0);
    WishRepository makewish = new WishRepository();

    @GetMapping("/Wish")
    public String wish(Model model) {
    model.addAttribute("wish",wish);
        return "/wish";
    }

    @GetMapping("/registerWish")
    public String register() {
        DBManager.getConnection();
        return "registerWish";
    }

    @PostMapping("/createWish")
    public String createRegister(@RequestParam("wishName") String wishName, @RequestParam("wishComment") String wishComment, @RequestParam("wishLink") String wishLink, @RequestParam("wishRank") int wishRank, @RequestParam("wishPrice") int wishPrice) {
        makewish.makeWish(wishName, wishComment, wishLink, wishRank, wishPrice);
        System.out.println();
        return "redirect:/wish";
    }
}


