package pl.artur97szat.shopanchor.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddProductDto {

    private Long id;

    @NotBlank
    private String url;

    @NotBlank
    private String name;

    @NotNull
    private Long shopId;

    @NotBlank
    private String size;

    private Boolean available;

    private String created;

}
