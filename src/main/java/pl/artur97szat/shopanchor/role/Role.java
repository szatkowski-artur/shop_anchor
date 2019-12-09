package pl.artur97szat.shopanchor.role;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity @Table(name = "roles")
@Data @EqualsAndHashCode(of = "id")
public class Role {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;



}
