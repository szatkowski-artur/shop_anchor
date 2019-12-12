package pl.artur97szat.shopanchor.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artur97szat.shopanchor.shop.DefaultShopService;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final DefaultShopService defaultShopService;
    private final DefaultProductService productService;

    public ProductController(DefaultShopService defaultShopService, DefaultProductService productService) {
        this.defaultShopService = defaultShopService;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addProductForm(String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("product", new AddProductDto());
        model.addAttribute("shops", defaultShopService.getAllShops());
        return "user/add-product";
    }

    @PostMapping("/add")
    public String processAddingProduct(@ModelAttribute AddProductDto addProductDto, BindingResult result){
        if (result.hasErrors()){
            return "user/add-product";
        }
        productService.saveProduct(addProductDto);
        return String.format("redirect:all?username=%s", addProductDto.getUsername());
    }

    @GetMapping("/all")
    public String allProducts(String username, Model model){
        model.addAttribute("username", username);
        model.addAttribute("products", productService.getAllProductsForUser(username));
        return "user/all-products";
    }

    @GetMapping("/delete")
    public String deleteProduct(Long id, Model model){
        model.addAttribute("id", id);
        return "";
    }

}
