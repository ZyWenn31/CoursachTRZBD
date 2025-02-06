package ru.tserk.coursach.coursach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tserk.coursach.coursach.models.Item;
import ru.tserk.coursach.coursach.services.ItemService;
import ru.tserk.coursach.coursach.util.ItemValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemValidator itemValidator;
    private final ItemService itemService;

    @Autowired
    public ItemsController(ItemValidator itemValidator, ItemService itemService) {
        this.itemValidator = itemValidator;
        this.itemService = itemService;
    }

    //Главная страница учетов товаров
    @GetMapping("")
    public String itemsMainPage(){
        return "/items/ItemsMainPage";
    }

    //Страница создания новых товаров
    @GetMapping("/add")
    public String newItem(@ModelAttribute("item") Item item){
        return "/items/newItem";
    }

    //ДОБАВИТЬ ПРОСМОТОР ВСЕХ СОЗДАННЫХ ТОВАРОВ
    @PostMapping("/add")
    public String postNewItem(@ModelAttribute("item") Item item, BindingResult bindingResult){
        itemValidator.validate(item, bindingResult);
        if (bindingResult.hasErrors()){
            return "items/newItem";
        }

        itemService.save(item);

        return "redirect:/items/add";
    }
}
