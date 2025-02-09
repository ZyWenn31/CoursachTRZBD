package ru.tserk.coursach.coursach.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tserk.coursach.coursach.models.Item;
import ru.tserk.coursach.coursach.services.ItemService;

@Component
public class EditItemValidator {

    private final ItemService itemService;

    public EditItemValidator(ItemService itemService) {
        this.itemService = itemService;
    }

    public boolean supports(Class<?> aClass) {
        return Item.class.equals(aClass);
    }


    public void validate(Object o, Errors errors, int id) {
        Item item = (Item)o;

        if (item.getLabel().equals(itemService.findOneItem(id).getLabel())){
            return;
        }
        if(itemService.findItemByLabel(item.getLabel()).isPresent()){
            errors.rejectValue("label", "", "Техника с таким названием уже существует");
        }
        else {
            return;
        }
    }
}
