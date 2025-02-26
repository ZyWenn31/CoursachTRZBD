package ru.tserk.coursach.coursach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tserk.coursach.coursach.models.Shop;
import ru.tserk.coursach.coursach.models.ShopItem;
import ru.tserk.coursach.coursach.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
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

    public List<Shop> searchShopByAddress(String address){
        if (address.isEmpty()){
            return List.of();
        }
        return shopRepository.findByAddressStartingWith(address);
    }

    public Shop findShopById(int id){
        return shopRepository.findById(id);
    }
}
