package pl.artur97szat.shopanchor.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByUserIdOrderByUpdatedDesc(Long id);

    List<Product> findTop5ByUserIdOrderByUpdatedDesc(Long id);


}
