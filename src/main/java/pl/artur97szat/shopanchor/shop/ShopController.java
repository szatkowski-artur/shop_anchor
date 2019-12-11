package pl.artur97szat.shopanchor.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
