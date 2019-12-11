package pl.artur97szat.shopanchor.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.artur97szat.shopanchor.product.Product;
import pl.artur97szat.shopanchor.role.Role;
import pl.artur97szat.shopanchor.userDetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false) @ToString.Exclude
    private String password;

    @Column(nullable = false)
    private Boolean active = Boolean.FALSE;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL) @ToString.Exclude
    private UserDetails details;

    @ManyToMany @ToString.Exclude
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Product> product;

}
