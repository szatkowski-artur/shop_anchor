package pl.artur97szat.shopanchor.shop.elements;

import lombok.extern.slf4j.Slf4j;
import pl.artur97szat.shopanchor.exeption.ShopNotSupportedException;
import pl.artur97szat.shopanchor.shop.ShopType;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public class ChooseShopFactory {

    public static ElementStrategy chooseShop(ShopType shopType) throws ShopNotSupportedException {

        try {
            return shopType.getStrategy()
                    .getDeclaredConstructor()
                    .newInstance();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("No implementation found for that shop name");
            throw new ShopNotSupportedException("This shop is not supported");
        }


    }

}
