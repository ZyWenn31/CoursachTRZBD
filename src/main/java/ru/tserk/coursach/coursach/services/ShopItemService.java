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
            shopItem1.setCount(shopItem1.getCount() + shopItem.getCount());
            shopItemRepository.save(shopItem1);
        }
        else{
            shopItemRepository.save(shopItem);
        }
    }

    public List<ShopItem> findAllShopItemByShopId(Shop shop){
        return shopItemRepository.findAllBySId(shop);
    }

    public ShopItem findShopItemById(int shopItemId){
        return shopItemRepository.findById(shopItemId).orElse(null);
    }

    @Transactional
    public void deleteShopItem(int count, int shopItemId){
        ShopItem shopItem = shopItemRepository.findById(shopItemId).orElse(null);
        if (count >= shopItem.getCount()){
            shopItemRepository.deleteById(shopItemId);
        } else {
            shopItem.setCount(shopItem.getCount() - count);
            shopItemRepository.save(shopItem);
        }
    }
}
