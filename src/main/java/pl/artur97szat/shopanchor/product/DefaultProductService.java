package pl.artur97szat.shopanchor.product;

import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.shop.ShopRepository;

@Service
public class DefaultProductService implements ProductService {

    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;

    public DefaultProductService(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }


}
