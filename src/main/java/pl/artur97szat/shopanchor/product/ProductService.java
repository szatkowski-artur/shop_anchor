package pl.artur97szat.shopanchor.product;

import java.util.List;

public interface ProductService {
    void saveProduct(AddProductDto addProductDto);

    List<Product> getAllProductsForUser();

    List<Product> getNewestFiveForUser();

    AddProductDto getProductByIdToAddProductDTO(Long id);
}
