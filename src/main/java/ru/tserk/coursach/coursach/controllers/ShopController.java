package ru.tserk.coursach.coursach.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tserk.coursach.coursach.security.PersonDetails;
import ru.tserk.coursach.coursach.services.ShopService;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }


    @GetMapping()
    public String shopPage(Model model){
        model.addAttribute("shops", shopService.findAllShops());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "shopPage";
    }
}
