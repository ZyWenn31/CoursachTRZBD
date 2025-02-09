package ru.tserk.coursach.coursach.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tserk.coursach.coursach.models.Item;
import ru.tserk.coursach.coursach.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<Item> findItemByLabel(String label){
        return itemRepository.findByLabel(label);
    }

    @Transactional(readOnly = false)
    public void save(Item item){
        itemRepository.save(item);
    }

    public Item findOneItem(int id){
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> searchItemByLabel(String item_label){
        if (item_label.isEmpty()){
            return List.of();
        }
        return itemRepository.findByLabelStartingWith(item_label);
    }

    @Transactional
    public void delete(int id){
        itemRepository.deleteById(id);
    }

    @Transactional
    public void updateItem(int id, Item itemFields){
        Item existingItem = itemRepository.findById(id).orElse(null);

        existingItem.setItem_price(itemFields.getItem_price());
        existingItem.setCategory_id(itemFields.getCategory_id());
        existingItem.setDescription(itemFields.getDescription());
        existingItem.setLabel(itemFields.getLabel());

        itemRepository.save(existingItem);
    }
}
