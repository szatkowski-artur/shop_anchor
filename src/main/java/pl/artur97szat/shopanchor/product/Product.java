package pl.artur97szat.shopanchor.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.artur97szat.shopanchor.shop.Shop;
import pl.artur97szat.shopanchor.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    @ToString.Exclude
    private User user;

}
