package pl.artur97szat.shopanchor.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artur97szat.shopanchor.product.DefaultProductService;

@Secured("ROLE_USER")
@Controller
@RequestMapping("/user")
public class UserController {

    private final DefaultProductService productService;

    public UserController(DefaultProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String userHomePage(Model model) {
        model.addAttribute("products", productService.getNewestFiveForUser());
        return "user/user-dashboard";
    }

    @PostMapping
    public String redirectToEdit(Long productId, Model model){
        model.addAttribute("productId", productId);
        return "product/all-products";
    }

}
