package pl.artur97szat.shopanchor.product;

import lombok.Data;
import pl.artur97szat.shopanchor.validation.constrains.IsShopImplemented;

import javax.validation.constraints.NotBlank;

@Data
public class AddProductDto {

    private Long id;

    @NotBlank
    @IsShopImplemented(message = "This shop have not been yet implemented")
    private String url;

    @NotBlank
    private String name;

    private Long shopId;

    @NotBlank
    private String size;

    private Boolean available;

    private String created;

}
