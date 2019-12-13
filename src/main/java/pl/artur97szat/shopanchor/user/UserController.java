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
    private final UserService userService;

    public UserController(DefaultProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public String userHomePage(Model model) {
        productService.updateAllProductsForUser();
        model.addAttribute("products", productService.getNewestFiveForUser());
        return "user/user-dashboard";
    }

    @PostMapping
    public String redirectToEdit(Long productId, Model model){
        model.addAttribute("productId", productId);
        return "product/all-products";
    }

    @GetMapping("/details")
    private String userDetails(Model model){

        model.addAttribute("userData", userService.getAllUsersData());

    }

}
