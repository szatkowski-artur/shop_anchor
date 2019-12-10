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

    @NotNull
    private Long owner;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Gender gender;

    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank @Pattern(regexp = "\\d{5}")
    private String postalCode;

    @NotBlank
    private String streetName;

    @NotBlank
    private String streetNumber;

    private String flatNumber;

}
