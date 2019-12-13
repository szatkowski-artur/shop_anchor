package pl.artur97szat.shopanchor.user;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.artur97szat.shopanchor.userDetails.Gender;
import pl.artur97szat.shopanchor.validation.constrains.RegistrationEmailDb;
import pl.artur97szat.shopanchor.validation.constrains.UpdateUserData;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data @UpdateUserData(message = "This username is already in use")
public class UserDataDto {

    private Long id;

    @NotBlank(message = "Cannot be empty")
    private String username;

    @NotBlank(message = "Cannot be empty")
    @Email(message = "This is not a proper email address")
    private String email;

    @NotBlank(message = "Cannot be empty")
    private String detailsFirstName;

    @NotBlank(message = "Cannot be empty")
    private String detailsLastName;

    @NotNull(message = "Cannot be empty")
    private Gender detailsGender;

    @NotNull(message = "Cannot be empty") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate detailsBirthday;

    @NotBlank(message = "Cannot be empty")
    private String detailsCountry;

    @NotBlank(message = "Cannot be empty")
    private String detailsCity;

    @NotBlank(message = "Cannot be empty")
    @Pattern(regexp = "\\d{5}", message = "Postal code contains five digits")
    private String detailsPostalCode;

    @NotBlank(message = "Cannot be empty")
    private String detailsStreetName;

    @NotBlank(message = "Cannot be empty")
    private String detailsStreetNumber;

    private String detailsFlatNumber;


}
