package pl.artur97szat.shopanchor.product;

import lombok.Data;
import pl.artur97szat.shopanchor.shop.ShopType;

@Data
public class AddProductDto {

    private String username;

    private String url;

    private String name;

    private Long shop;

    private String size;

}
