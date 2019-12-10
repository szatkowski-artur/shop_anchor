package pl.artur97szat.shopanchor.registration.first;

import lombok.Data;
import pl.artur97szat.shopanchor.validation.constrains.EmailDb;
import pl.artur97szat.shopanchor.validation.constrains.RetypePassword;
import pl.artur97szat.shopanchor.validation.constrains.UsernameDb;


import javax.validation.constraints.*;

@Data @RetypePassword(message = "Passwords must be the same")
public class FirstRegistrationDataDTO {


    @NotBlank
    @Size(min = 5, max = 12)
    @UsernameDb(message = "This username is already in use")
    private String username;

    @Email
    @NotBlank
    @EmailDb(message = "This email is already in use")
    private String email;

    @NotBlank
    @Size(min = 8, max = 25)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{8,25}$",
            message = "Password must contain at least one uppercase and lowercase letter and a digit")
    private String password;

    @NotBlank
    @Size(min = 8, max = 25)
    private String rePassword;

    @NotNull
    @AssertTrue
    private Boolean termsAndConditions;

}
