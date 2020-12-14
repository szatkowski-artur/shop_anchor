package pl.artur97szat.shopanchor.shop.elements;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Scanner;

public class HM implements ElementStrategy {

    @Override
    public Element getElement(Document document) {

        return document.getElementsByClass("product parbase").first().selectFirst("script");

    }

    @Override
    public Boolean isAvailable(Document document, String size) {

        String scriptData = getElement(document).data();
        scriptData = scriptData.substring(scriptData.indexOf("sizes"), scriptData.indexOf("whitePrice"));
        Scanner scanner = new Scanner(scriptData);
        String line;

        while (scanner.hasNext()) {
            line = scanner.nextLine();

            if (line.toLowerCase().contains(size.toLowerCase())) {
                scanner.close();
                return true;
            }
        }

        return false;
    }
}
