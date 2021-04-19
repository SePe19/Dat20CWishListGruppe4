package gruppe4.aws.controllers;

import gruppe4.aws.models.Wish;
import gruppe4.aws.repository.DBManager;
import gruppe4.aws.repository.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WishController {
    WishRepository makeNewWish = new WishRepository();

    @GetMapping("/Wish")
    public String wish(Model model) {
        return "/wish";
    }

    @GetMapping("/registerWish")
    public String registerWish() {
        DBManager.getConnection();
        return "/registerWish";
    }

    @PostMapping("/createWish")
    public String createWish(HttpServletRequest request, @RequestParam("wishName") String wishName, @RequestParam("wishComment") String wishComment, @RequestParam("wishLink") String wishLink, @RequestParam("wishRank") int wishRank, @RequestParam("wishPrice") double wishPrice) {
        HttpSession session = request.getSession();
        String accountName = (String) session.getAttribute("accountName");
        makeNewWish.makeWish(wishName, wishComment, wishLink, wishRank, wishPrice, accountName);

        return "redirect:/wishList";
    }
}