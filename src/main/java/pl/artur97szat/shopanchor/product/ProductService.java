package pl.artur97szat.shopanchor.product;

import org.jsoup.nodes.Document;
import pl.artur97szat.shopanchor.exeption.CouldNotConnectToPageException;

import java.util.List;

public interface ProductService {
    void saveProduct(AddProductDto addProductDto);

    List<Product> getAllProductsForUser();

    void updateAllProductsForUser();

    void updateAllProducts();

    List<Product> getNewestFiveForUser();

    AddProductDto getProductByIdToAddProductDTO(Long id);
}
