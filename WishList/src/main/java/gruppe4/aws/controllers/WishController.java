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
    WishRepository makeNewWish = new WishRepository();

    @GetMapping("/Wish")
    public String wish(Model model) {
        model.addAttribute("wish", wish);
        return "/wish";
    }

    @GetMapping("/registerWish")
    public String registerWish() {
        DBManager.getConnection();
        return "/registerWish";
    }

    @PostMapping("/createWish")
    public String createWish(@RequestParam("wishName") String wishName, @RequestParam("wishComment") String wishComment, @RequestParam("wishLink") String wishLink, @RequestParam("wishRank") int wishRank, @RequestParam("wishPrice") double wishPrice) {
        makeNewWish.makeWish(wishName, wishComment, wishLink, wishRank, wishPrice);
        System.out.println(wishName + wishComment + wishLink + wishRank + wishPrice);
        return "redirect:/wishList";
    }
}


