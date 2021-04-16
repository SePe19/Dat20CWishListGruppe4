package gruppe4.aws.controllers;

import gruppe4.aws.models.User;
import gruppe4.aws.models.Wish;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.WishRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

public class WishListController {
WishRepository wishRep = new WishRepository();
    @GetMapping("wishList")
    public String wishList(Model model) {
        DBManager.getConnection();
        ArrayList<Wish> allWishes = wishRep.showAllWishes();
        model.addAttribute("wishList", allWishes);
        return "/wish";
    }
}
