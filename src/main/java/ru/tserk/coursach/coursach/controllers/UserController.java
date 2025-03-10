package ru.tserk.coursach.coursach.controllers;

import org.dom4j.rule.Mode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tserk.coursach.coursach.security.PersonDetails;
import ru.tserk.coursach.coursach.services.ItemService;
import ru.tserk.coursach.coursach.services.ShopItemService;
import ru.tserk.coursach.coursach.services.ShopService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequestMapping("/main")
public class UserController {


    private final ShopService shopService;
    private final ShopItemService shopItemService;
    private final ItemService itemService;

    public UserController(ShopService shopService, ShopItemService shopItemService, ItemService itemService) {
        this.shopService = shopService;
        this.shopItemService = shopItemService;
        this.itemService = itemService;
    }


    //Переход на главную страницу
    @GetMapping
    public String mainPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        model.addAttribute("person", personDetails.getPerson());
        model.addAttribute("role", personDetails.getPerson().getRole());
        return "user/mainPage";
    }

    @GetMapping("all")
    public String allItems(Model model){
        model.addAttribute("allItems", itemService.findAll());
        return "user/allItems";
    }

    @GetMapping("/download-file")
    public void downloadFile(@RequestParam("role") String role, HttpServletResponse response) throws IOException {
        // Определяем имя файла по параметру type
        String fileName;
        if (role.equals("ROLE_ADMIN")) {
            fileName = "admin.pdf";
        } else {
            fileName = "user.pdf";
        }

        // Загружаем файл из ресурсов (например, из папки resources/static)
        Resource resource = new ClassPathResource("static/" + fileName);
        Path path = resource.getFile().toPath();
        byte[] fileContent = Files.readAllBytes(path);

        // Определяем content type в зависимости от типа файла
        String contentType = "application/pdf";

        // Устанавливаем заголовки ответа
        response.setContentType(contentType);
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);

        // Записываем содержимое файла в output stream ответа
        response.getOutputStream().write(fileContent);
        response.getOutputStream().flush();
    }

    //Страница поиска
    @GetMapping("/search")
    public String searchPage(){
        return "user/searchPage";
    }

    //Страница результатов
    @PostMapping("/search")
    public String postSearchPage(@RequestParam("label")String item_label,
                                 Model model){
        model.addAttribute("items", itemService.searchItemByLabel(item_label));

        return "user/searchedPage";
    }

    //Страница конкретной техники
    @GetMapping("/itemInfo/{id}")
    public String getItemInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("item", itemService.findOneItem(id));
        model.addAttribute("shops", shopService.findAllShopByItemId(shopItemService.findAllByItem(itemService.findOneItem(id))));
        return "user/itemPage";
    }
}
