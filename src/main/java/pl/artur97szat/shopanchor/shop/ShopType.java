package pl.artur97szat.shopanchor.shop;

import pl.artur97szat.shopanchor.shop.elements.ElementStrategy;
import pl.artur97szat.shopanchor.shop.elements.Zara;

public enum ShopType {

    ZARA(Zara.class, "Zara");

    private final Class<? extends ElementStrategy> strategy;
    private final String presentation;

    ShopType(Class<? extends ElementStrategy> strategy, String presentation) {
        this.strategy = strategy;
        this.presentation = presentation;
    }

    public Class<? extends ElementStrategy> getStrategy() {
        return strategy;
    }
}
