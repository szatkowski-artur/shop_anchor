package pl.artur97szat.shopanchor.registration.registrationCode;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.artur97szat.shopanchor.user.User;

import javax.persistence.*;

@Entity @Table(name = "registration_codes")
@Data @EqualsAndHashCode(of = "code")
public class RegistrationCode {

    @Id @Column(nullable = false, unique = true)
    private String code;

    @OneToOne
    private User user;

}
