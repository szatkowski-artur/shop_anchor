package pl.artur97szat.shopanchor.registration.first;

import lombok.Data;


import javax.validation.constraints.*;

@Data
public class FirstRegistrationDataDTO {


    @NotBlank
    @Size(min = 5, max = 12)
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

    @NotBlank
    @Size(min = 8, max = 16)
    private String rePassword;

    @NotNull
    @AssertTrue
    private Boolean termsAndConditions;

}
