package pl.artur97szat.shopanchor.registration.details;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.artur97szat.shopanchor.userDetails.Gender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class DetailsRegistrationDataDTO {

    @NotNull(message = "Cannot be empty")
    private Long owner;

    @NotBlank(message = "Cannot be empty")
    private String firstName;

    @NotBlank(message = "Cannot be empty")
    private String lastName;

    @NotNull(message = "Cannot be empty")
    private Gender gender;

    @NotNull(message = "Cannot be empty") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

    @NotBlank(message = "Cannot be empty")
    private String country;

    @NotBlank(message = "Cannot be empty")
    private String city;

    @NotBlank(message = "Cannot be empty")
    @Pattern(regexp = "\\d{5}", message = "Postal code contains five digits")
    private String postalCode;

    @NotBlank(message = "Cannot be empty")
    private String streetName;

    @NotBlank(message = "Cannot be empty")
    private String streetNumber;

    private String flatNumber;

}
