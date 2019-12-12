package pl.artur97szat.shopanchor.shop.elements;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Zara implements ElementStrategy {

    @Override
    public Element getElement(Document document) {
        return document.getElementsByClass("size-list").first();
    }

    @Override
    public Boolean isAvailable(Document document, String size) {

        Element freshElement = getElement(document);

        for (String sizes : freshElement.children().eachAttr("data-name")) {
            if (size.equalsIgnoreCase(sizes)) {
                return true;
            }
        }

        return false;
    }


}
