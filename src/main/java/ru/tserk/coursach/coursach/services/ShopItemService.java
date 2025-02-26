package ru.tserk.coursach.coursach.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tserk.coursach.coursach.models.Item;
import ru.tserk.coursach.coursach.models.Shop;
import ru.tserk.coursach.coursach.models.ShopItem;
import ru.tserk.coursach.coursach.repositories.ShopItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ShopItemService {

    private final ShopItemRepository shopItemRepository;

    public ShopItemService(ShopItemRepository shopItemRepository) {
        this.shopItemRepository = shopItemRepository;
    }

    public List<ShopItem> findAllByItem(Item item){
        return shopItemRepository.findAllByItId(item);
    }
    public List<ShopItem> findShopItemsByShopId(Shop shop){
        return shopItemRepository.findAllBySId(shop);
    }

    @Transactional
    public void saveShopItem(ShopItem shopItem, Shop shop, Item item){
        if (shopItemRepository.findShopItemByItIdAndSId(item, shop).isPresent()){
            ShopItem shopItem1 = shopItemRepository.findShopItemByItIdAndSId(item, shop).orElse(null);
            
        }

        shopItemRepository.save(shopItem);
    }
}
