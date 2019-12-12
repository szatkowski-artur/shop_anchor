package pl.artur97szat.shopanchor.product;

import java.util.List;

public interface ProductService {
    void saveProduct(AddProductDto addProductDto);

    List<Product> getAllProductsForUser(String username);

    List<Product> getNewestFiveForUser(String username);
}
