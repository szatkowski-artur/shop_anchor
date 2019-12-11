package pl.artur97szat.shopanchor.shop.elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

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


    public static void main(String[] args) {
        Zara zara = new Zara();

        try {
            zara.isAvailable(Jsoup.connect(
                    "https://www.zara.com/pl/pl/p%C5%82aszcz-z-tkaniny-strukturalnej-w-krat%C4%99-p06529118.html?v1=32844371&v2=1282966")
                    .get(), "M");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
