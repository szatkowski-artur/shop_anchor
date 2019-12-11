package pl.artur97szat.shopanchor.shop.elements;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public interface ElementStrategy {

    Element getElement(Document document);


    Boolean isAvailable(Document document, String size);
}
