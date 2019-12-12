package pl.artur97szat.shopanchor.product;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.artur97szat.shopanchor.shop.DefaultShopService;

import javax.validation.Valid;

@Secured("ROLE_USER")
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
    public String addProductForm(Model model) {
        model.addAttribute("product", new AddProductDto());
        model.addAttribute("shops", defaultShopService.getAllShops());
        return "user/add-product";
    }

    @PostMapping("/add")
    public String processAddingProduct(@ModelAttribute @Valid AddProductDto addProductDto, BindingResult result) {
        if (result.hasErrors()) {
            return "user/add-product";
        }
        productService.saveProduct(addProductDto);
        return "redirect:all";
    }

    @GetMapping("/all")
    public String allProducts(Long productId, Model model) {
        model.addAttribute("products", productService.getAllProductsForUser());
        if (productId != null) {
            model.addAttribute("editProduct", productService.getProductByIdToAddProductDTO(productId));
            model.addAttribute("shops", defaultShopService.getAllShops());
        }
        model.addAttribute("productId", productId);
        return "user/all-products";
    }

    @GetMapping("/delete")
    public String deleteProduct(Long id, Model model) {
        model.addAttribute("product", productService.getProductByIdToAddProductDTO(id));
        return "user/delete-product";
    }

    @RequestMapping("/delete")
    public String processDeletingProduct(AddProductDto addProductDto){
        productService.deleteProduct(addProductDto.getId());
        return "redirect:all";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute @Valid AddProductDto productDto, Long productId, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productId", productId);
            model.addAttribute("editProduct", productService.getProductByIdToAddProductDTO(productId));
            model.addAttribute("shops", defaultShopService.getAllShops());
            return "user/all-products";
        }
        productService.updateProduct(productDto);
        return "redirect:all";
    }

    @PostMapping("/user/refresh")
    public String refreshAllProducts(){
        productService.updateAllProductsForUser();
        return "redirect:/product/all";
    }

}
