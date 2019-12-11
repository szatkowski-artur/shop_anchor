package pl.artur97szat.shopanchor.shop;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.exeption.CouldNotConnectToPageException;
import pl.artur97szat.shopanchor.exeption.ShopNotSupportedException;
import pl.artur97szat.shopanchor.shop.elements.ChooseShopFactory;

import java.io.IOException;

@Service
@Slf4j
public class DefaultShopService implements ShopService {



    @Override
    public String getSectionToObserve(String url, ShopType shopName) throws CouldNotConnectToPageException, ShopNotSupportedException {

        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            log.error("Nie udało się połączyć z url", e);
            throw new CouldNotConnectToPageException("Couldn't connect with shop from url", e);
        }

       return ChooseShopFactory.chooseShop(shopName).getElement(document).html();

    }
}
