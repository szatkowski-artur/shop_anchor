package pl.artur97szat.shopanchor.product;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.exeption.CouldNotConnectToPageException;
import pl.artur97szat.shopanchor.exeption.ShopNotSupportedException;
import pl.artur97szat.shopanchor.shop.Shop;
import pl.artur97szat.shopanchor.shop.ShopService;
import pl.artur97szat.shopanchor.shop.ShopType;
import pl.artur97szat.shopanchor.shop.elements.ElementStrategy;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.utils.Username;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ShopService shopService;


    public DefaultProductService(ProductRepository productRepository, UserRepository userRepository, ModelMapper mapper, ShopService shopService) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.shopService = shopService;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void saveProduct(AddProductDto addProductDto) {

        Product product = mapper.map(addProductDto, Product.class);
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());
        product.setUser(userRepository.getByUsername(Username.get()).get());
        productRepository.save(product);

    }

    public void updateProduct(AddProductDto addProductDto) {
        Product product = mapper.map(addProductDto, Product.class);
        product.setUpdated(LocalDateTime.now());
        product.setCreated(LocalDateTime.parse(addProductDto.getCreated()));
        product.setUser(userRepository.getByUsername(Username.get()).get());
        productRepository.save(product);
    }


    public Boolean checkIfAvailable(Product product) throws CouldNotConnectToPageException {
        Document document = null;
        try {
            document = Jsoup.connect(product.getUrl()).get();
        } catch (IOException e) {
            log.error("Nie udało się połączyć z url", e);
            throw new CouldNotConnectToPageException("Couldn't connect with shop from url", e);
        }
        try {
            return shopService.getShopImplementation(product.getShop().getType()).isAvailable(document, product.getSize());
        } catch (ShopNotSupportedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAllProductsForUser() {
        return productRepository.findAllByUserIdOrderByUpdatedDesc(
                userRepository.getByUsername(Username.get()).get().getId());
    }

    @Override
    public void updateAllProductsForUser() {
        List<Product> products = productRepository.findAllByUserIdOrderByUpdatedDesc(
                userRepository.getByUsername(Username.get()).get().getId());
        products.stream().forEach(p -> {
            try {
                p.setAvailable(checkIfAvailable(p));
            } catch (CouldNotConnectToPageException e) {
                e.printStackTrace();
            }
        });

        productRepository.saveAll(products);

    }

    @Override
    public void updateAllProducts() {
        List<Product> products = productRepository.findAll();
        products.stream().forEach(p -> {
            try {
                p.setAvailable(checkIfAvailable(p));
            } catch (CouldNotConnectToPageException e) {
                e.printStackTrace();
            }
        });

        productRepository.saveAll(products);

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
