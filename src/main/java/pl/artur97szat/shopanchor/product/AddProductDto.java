package pl.artur97szat.shopanchor.product;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddProductDto {

    private Long id;

    private String url;

    private String name;

    private Long shopId;

    private String size;

    private Boolean available;

    private String created;

}
