package pl.artur97szat.shopanchor.product;

import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.shop.ShopRepository;
import pl.artur97szat.shopanchor.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public DefaultProductService(ShopRepository shopRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveProduct(AddProductDto addProductDto) {

        Product product = new Product();
        product.setName(addProductDto.getName());
        product.setShop(shopRepository.getOne(addProductDto.getShop()));
        product.setUrl(addProductDto.getUrl());
        product.setSize(addProductDto.getSize());
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());
        product.setAvailable(false);
        product.setUser(userRepository.getByUsername(addProductDto.getUsername()).get());
        productRepository.save(product);

    }

    public List<Product> getAllProductsForUser(String username) {
        return productRepository.findAllByUserId(userRepository.getByUsername(username).get().getId());
    }


}
