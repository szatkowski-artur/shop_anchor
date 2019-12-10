package pl.artur97szat.shopanchor.userDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.artur97szat.shopanchor.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Table(name = "users_details")
@Data @EqualsAndHashCode(of = "id")
public class UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthday;
    private String country;
    private String postalCode;
    private String city;
    private String streetName;
    private String streetNumber;
    private String flatNumber;
    @OneToOne
    private User owner;



}
