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
import java.util.ArrayList;

@Controller
public class WishController {
    WishRepository makeNewWish = new WishRepository();

    @GetMapping("/wish")
    public String wish(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String accountName = (String) session.getAttribute("accountName");
        ArrayList<Wish> userWishList = makeNewWish.getAccountWishList(accountName);
        model.addAttribute("userWishList", userWishList);
        return "/wish";
    }

    @PostMapping("/deleteWish")
    public String deleteWish(@RequestParam("wishID")int wishID){
        makeNewWish.deleteWish(wishID);
        return "redirect:/wish";
    }

    @GetMapping("/registerWish")
    public String registerWish() {
        DBManager.getConnection();
        return "/registerWish";
    }

    @PostMapping("/createWish")
    public String createWish(HttpServletRequest request, @RequestParam("wishName") String wishName,
                             @RequestParam("wishComment") String wishComment, @RequestParam("wishLink") String wishLink,
                             @RequestParam("wishRank") int wishRank, @RequestParam("wishPrice") double wishPrice) {

        HttpSession session = request.getSession();
        String accountName = (String) session.getAttribute("accountName");
        makeNewWish.makeWish(wishName, wishComment, wishLink, wishRank, wishPrice, accountName);
        return "redirect:/wish";
    }
}