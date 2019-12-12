package pl.artur97szat.shopanchor.product;

import lombok.Data;

@Data
public class AddProductDto {

    private String username;

    private String url;

    private String name;

    private Long shopId;

    private String size;

    private Boolean available;

}
