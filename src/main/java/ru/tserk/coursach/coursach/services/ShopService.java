package ru.tserk.coursach.coursach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tserk.coursach.coursach.models.Shop;
import ru.tserk.coursach.coursach.models.ShopItem;
import ru.tserk.coursach.coursach.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> findAllShops(){
        return shopRepository.findAll();
    }

    public List<Shop> findAllShopByItemId(List<ShopItem> shopItems){
        List<Shop> result = new ArrayList<>();

        for (ShopItem shopItem : shopItems){
            result.add(shopRepository.findById(shopItem.getShop_id().getShop_id()));
        }

        return result;
    }
}
