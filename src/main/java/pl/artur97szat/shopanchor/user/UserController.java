package pl.artur97szat.shopanchor.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artur97szat.shopanchor.product.DefaultProductService;
import pl.artur97szat.shopanchor.userDetails.Gender;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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
    public String userDetails(Model model){

        model.addAttribute("readonly", true);
        model.addAttribute("userData", userService.getAllUsersData());
        return "user/user-details";

    }

    @ModelAttribute("genders")
    List<Gender> genders(){
        return Arrays.asList(Gender.values());
    }

    @ModelAttribute("countries")
    List<String> countries(){
        return Arrays.asList("POLAND", "GERMANY", "CZECH", "GREAT BRITAIN");
    }

    @GetMapping("/details/edit")
    public String editUserDetails(Model model){
        model.addAttribute("readonly", false);
        model.addAttribute("userData", userService.getAllUsersData());
        return "user/user-details";
    }

    @PostMapping("/details/edit")
    public String processEditUserDetails(@Valid @ModelAttribute("userData") UserDataDto userDataDto, BindingResult result){
        if (result.hasErrors()){
            return "user/user-details";
        }
        userService.updateUserData(userDataDto);
        return "redirect:";
    }

    @GetMapping("edit-password")
    public String editPassword(){
        return "";
    }

}
