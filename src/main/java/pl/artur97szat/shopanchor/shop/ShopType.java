package pl.artur97szat.shopanchor.shop;

import lombok.Getter;
import pl.artur97szat.shopanchor.shop.elements.ElementStrategy;
import pl.artur97szat.shopanchor.shop.elements.HM;
import pl.artur97szat.shopanchor.shop.elements.Zara;
public enum ShopType {

    ZARA(Zara.class, "Zara", "zara.com"),
    HM(HM.class, "H&M", "hm.com");

    @Getter
    private final Class<? extends ElementStrategy> strategy;

    @Getter
    private final String presentation;

    @Getter
    private final String url;

    ShopType(Class<? extends ElementStrategy> strategy, String presentation, String url) {
        this.strategy = strategy;
        this.presentation = presentation;
        this.url = url;
    }

    public static ShopType getByUrl(String url) {
        for (ShopType shopType : ShopType.values()) {
            if (url.toLowerCase().contains(shopType.getUrl()))
                return shopType;
        }
        return null;
    }


    public static boolean existByUrl(String url) {
        for (ShopType shopType : ShopType.values()) {
            if (url.toLowerCase().contains(shopType.getUrl()))
                return true;
        }
        return false;
    }

}
