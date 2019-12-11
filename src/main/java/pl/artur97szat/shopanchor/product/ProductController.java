package pl.artur97szat.shopanchor.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artur97szat.shopanchor.shop.DefaultShopService;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final DefaultShopService defaultShopService;

    public ProductController(DefaultShopService defaultShopService) {
        this.defaultShopService = defaultShopService;
    }

    @GetMapping("/add")
    public String addProductForm(String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("product", new AddProductDto());
        model.addAttribute("shops", defaultShopService.getAllShops());
        return "user/add-product";
    }

    @GetMapping("/all")
    public String allProducts(String username, Model model){
        model.addAttribute("username", username);
        return "";
    }

}
