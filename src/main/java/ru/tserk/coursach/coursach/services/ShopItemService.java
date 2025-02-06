package ru.tserk.coursach.coursach.services;

import org.springframework.stereotype.Service;
import ru.tserk.coursach.coursach.models.Item;
import ru.tserk.coursach.coursach.models.ShopItem;
import ru.tserk.coursach.coursach.repositories.ShopItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShopItemService {

    private final ShopItemRepository shopItemRepository;

    public ShopItemService(ShopItemRepository shopItemRepository) {
        this.shopItemRepository = shopItemRepository;
    }

    public List<ShopItem> findAllByItem(Optional<Item> item){
        return shopItemRepository.findAllByItId(item);
    }
}
