package pl.artur97szat.shopanchor.product;

import org.modelmapper.ModelMapper;
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

        ModelMapper mapper = new ModelMapper();
        Product product = mapper.map(addProductDto, Product.class);
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());
        product.setUser(userRepository.getByUsername(addProductDto.getUsername()).get());
        productRepository.save(product);

    }

    @Override
    public List<Product> getAllProductsForUser(String username) {
        return productRepository.findAllByUserId(userRepository.getByUsername(username).get().getId());
    }

    @Override
    public List<Product> getNewestFiveForUser(String username) {
        return productRepository.findTop5ByUserIdOrderByUpdatedDesc(
                userRepository.getByUsername(username).get().getId());
    }


}
