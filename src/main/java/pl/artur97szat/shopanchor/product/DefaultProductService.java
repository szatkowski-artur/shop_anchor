package pl.artur97szat.shopanchor.product;

import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.shop.ShopRepository;

import java.time.LocalDateTime;

@Service
public class DefaultProductService implements ProductService {

    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;

    public DefaultProductService(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    public void saveProduct(AddProductDto addProductDto) {

        Product product = new Product();
        product.setName(addProductDto.getName());
        product.setShop(shopRepository.getOne(addProductDto.getShop()));
        product.setUrl(addProductDto.getUrl());
        product.setSize(addProductDto.getSize());
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());
        product.setAvailable(false);
        productRepository.save(product);

    }

}
