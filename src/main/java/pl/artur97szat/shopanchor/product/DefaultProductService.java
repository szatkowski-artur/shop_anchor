package pl.artur97szat.shopanchor.product;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.utils.Username;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;


    public DefaultProductService(ProductRepository productRepository, UserRepository userRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveProduct(AddProductDto addProductDto) {

        Product product = mapper.map(addProductDto, Product.class);
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());
        product.setUser(userRepository.getByUsername(Username.get()).get());
        productRepository.save(product);

    }

    public void updateProduct(AddProductDto addProductDto){
        Product product = mapper.map(addProductDto, Product.class);
        product.setUpdated(LocalDateTime.now());
        product.setCreated(LocalDateTime.parse(addProductDto.getCreated()));
        product.setUser(userRepository.getByUsername(Username.get()).get());
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProductsForUser() {
        return productRepository.findAllByUserIdOrderByUpdatedDesc(userRepository.getByUsername(Username.get()).get().getId());
    }

    @Override
    public List<Product> getNewestFiveForUser() {
        return productRepository.findTop5ByUserIdOrderByUpdatedDesc(
                userRepository.getByUsername(Username.get()).get().getId());
    }

    @Override
    public AddProductDto getProductByIdToAddProductDTO(Long id) {
        Product product = productRepository.getOne(id);
        AddProductDto productDto = mapper.map(product, AddProductDto.class);
        productDto.setShopId(product.getShop().getId());
        return productDto;

    }


}
