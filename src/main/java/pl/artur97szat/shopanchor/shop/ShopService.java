package pl.artur97szat.shopanchor.shop;

import pl.artur97szat.shopanchor.exeption.CouldNotConnectToPageException;
import pl.artur97szat.shopanchor.exeption.ShopNotSupportedException;

public interface ShopService {

    String getSectionToObserve(String url, ShopType shopName) throws CouldNotConnectToPageException, ShopNotSupportedException;

}
