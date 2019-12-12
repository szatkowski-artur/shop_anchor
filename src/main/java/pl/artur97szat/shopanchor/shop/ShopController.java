package pl.artur97szat.shopanchor.shop;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Secured("ROLE_USER")//TODO change to ROLE_ADMIN, left now for convenience
@Controller @RequestMapping("/shop")
public class ShopController {

    private final DefaultShopService shopService;

    public ShopController(DefaultShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/update")
    public String updateShopDatabase(){
        shopService.updateShopDatabase();
        return "redirect:/";
    }

}
