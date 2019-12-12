package pl.artur97szat.shopanchor.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artur97szat.shopanchor.product.DefaultProductService;
import pl.artur97szat.shopanchor.product.ProductRepository;

import java.security.Principal;

@Secured("ROLE_USER")
@Controller
@RequestMapping("/user")
public class UserController {

    private final DefaultProductService productService;

    public UserController(DefaultProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String userHomePage(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("products", productService.getNewestFiveForUser(principal.getName()));
        return "user/user-dashboard";
    }

}
