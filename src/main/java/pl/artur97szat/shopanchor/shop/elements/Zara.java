package pl.artur97szat.shopanchor.shop.elements;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toList;


public class Zara implements ElementStrategy {

    @Override
    public Element getElement(Document document) {
        return document.getElementsByClass("size-list").first();
    }

    @Override
    public Boolean isAvailable(Document document, String size) {

        List<Element> elements = getElement(document).children().stream()
                .filter(e->!e.className().contains("disabled"))
                .collect(toList());

        for (Element element : elements) {
            if (size.equalsIgnoreCase(element.attr("data-name"))) {
                return true;
            }
        }

        return false;
    }


}
