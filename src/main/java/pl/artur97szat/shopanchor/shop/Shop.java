package pl.artur97szat.shopanchor.shop;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@Table(name = "shops")
@Data
@EqualsAndHashCode(of = "id")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)@Enumerated(EnumType.STRING)
    private ShopType type;

}
