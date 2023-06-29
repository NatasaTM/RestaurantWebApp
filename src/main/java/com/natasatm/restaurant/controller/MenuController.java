package com.natasatm.restaurant.controller;

import com.natasatm.restaurant.dto.MenuItemDto;
import com.natasatm.restaurant.model.MenuEntityCategory;
import com.natasatm.restaurant.service.MenuItemCategoryService;
import com.natasatm.restaurant.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MenuController {
    private MenuItemService menuItemService;
    private MenuItemCategoryService menuItemCategoryService;


    @Autowired
    public MenuController(MenuItemService menuItemEntityService, MenuItemCategoryService menuEntityCategoryService) {
        this.menuItemService = menuItemEntityService;
        this.menuItemCategoryService = menuEntityCategoryService;

    }

    @GetMapping("/menuItem-create.html")
    public String createMenuItemForm(Model model) {
        MenuItemDto menuItem = new MenuItemDto();
        List<MenuEntityCategory> menuCategories = menuItemCategoryService.getAllCategories();
        model.addAttribute("menuItem", menuItem);
        model.addAttribute("menuCategories", menuCategories);
        return "menuItem-create2";
    }

    @PostMapping("/menuItem-create.html")
    public String saveMenuItem(@ModelAttribute MenuItemDto menuItem) {

        menuItemService.addMenuItem(menuItem);
        return "redirect:/menu.html";
    }

    @GetMapping("/menu.html")
    public String menuItemsList(Model model) {

        List<MenuItemDto> menuItems = menuItemService.getAllMenuItems().stream().filter(menuItemDto -> menuItemDto.getActive()==true).collect(Collectors.toList());
        List<MenuEntityCategory> menuCategories = menuItemCategoryService.getAllCategories();
        model.addAttribute("menuItems", menuItems);
        model.addAttribute("menuCategories", menuCategories);
        return "menu";
    }

    @GetMapping("/menuItem-edit.html")
    public String updateMenuItem(@RequestParam("menuItemId") Long menuItemId, Model model) {

        MenuItemDto menuItem = menuItemService.findById(menuItemId);
        List<MenuEntityCategory> menuCategories = menuItemCategoryService.getAllCategories();
        System.out.println(menuItem);
        model.addAttribute("menuItem", menuItem);
        model.addAttribute("menuCategories", menuCategories);
        return "menuItem-edit";
    }

    @PostMapping("/menuItem-edit.html")
    public String updateMenuItem(@ModelAttribute MenuItemDto menuItem) {
        menuItemService.addMenuItem(menuItem);
        return "redirect:/menu.html";
    }

    @GetMapping("/menuItem-delete.html")
    public String deleteMenuItem(@RequestParam("menuItemId") Long menuItemId) {
        menuItemService.deleteById(menuItemId);
        return "redirect:/menu.html";
    }

    @GetMapping("/menuItems-edit.html")
    public String getEditMenuItemsForm(Model model) {
        List<MenuItemDto> menuItems = menuItemService.getAllMenuItems();
        List<MenuEntityCategory> menuCategories = menuItemCategoryService.getAllCategories();
        model.addAttribute("menuItems", menuItems);
        model.addAttribute("menuCategories", menuCategories);
        return "menuItems_list-edit";
    }


}
