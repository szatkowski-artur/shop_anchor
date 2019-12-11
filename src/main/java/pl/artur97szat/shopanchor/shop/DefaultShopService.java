package pl.artur97szat.shopanchor.shop;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.exeption.CouldNotConnectToPageException;
import pl.artur97szat.shopanchor.exeption.ShopNotSupportedException;
import pl.artur97szat.shopanchor.shop.elements.ChooseShopFactory;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class DefaultShopService implements ShopService {

    private final ShopRepository shopRepository;

    public DefaultShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

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

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public void updateShopDatabase(){

        for (ShopType shopType:ShopType.values()){

            Shop shop = new Shop();
            shop.setName(shopType.getPresentation());
            shop.setType(shopType);
            shopRepository.save(shop);

        }

    }
}
