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

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private String country;

    @OneToOne
    private User owner;



}
