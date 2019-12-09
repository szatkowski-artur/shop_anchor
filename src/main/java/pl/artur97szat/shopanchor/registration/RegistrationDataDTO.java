package pl.artur97szat.shopanchor.registration;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.artur97szat.shopanchor.userDetails.Gender;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
public class RegistrationDataDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank @Size(min = 5, max = 12)
    private String username;

    @Email @NotBlank
    private String email;

    @NotBlank @DateTimeFormat
    private LocalDate birthday;

    @NotBlank
    private String country;

    @NotBlank
    private Gender gender;

    @NotBlank @Size(min = 8, max = 16)
    private String password;

    @NotBlank @Size(min = 8, max = 16)
    private String rePassword;

    @NotNull @AssertTrue
    private Boolean termsAndConditions;

}
