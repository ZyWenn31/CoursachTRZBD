package ru.tserk.coursach.coursach.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tserk.coursach.coursach.models.Item;
import ru.tserk.coursach.coursach.services.ItemService;

@Component
public class ItemValidator implements Validator {

    private final ItemService itemService;

    public ItemValidator(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Item.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Item item = (Item)o;

        if(itemService.findItemByLabel(item.getLabel()).isPresent()){
            errors.rejectValue("label", "", "Техника с таким названием уже существует");
        }
        else {
            return;
        }
    }
}
