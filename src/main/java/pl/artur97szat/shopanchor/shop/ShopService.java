package pl.artur97szat.shopanchor.shop;

import pl.artur97szat.shopanchor.exeption.CouldNotConnectToPageException;
import pl.artur97szat.shopanchor.exeption.ShopNotSupportedException;
import pl.artur97szat.shopanchor.shop.elements.ElementStrategy;

import java.util.List;

public interface ShopService {

    ElementStrategy getShopImplementation(ShopType shopType) throws CouldNotConnectToPageException, ShopNotSupportedException;

    Shop getShopByType(ShopType shopType);

    List<Shop> getAllShops();

    void updateShopDatabase();
}
