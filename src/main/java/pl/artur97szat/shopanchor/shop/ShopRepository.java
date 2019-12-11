package pl.artur97szat.shopanchor.shop;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Override
    <S extends Shop> List<S> saveAll(Iterable<S> iterable);
}
