package com.natasatm.restaurant.controller;

import com.natasatm.restaurant.dto.MenuEntityDto;
import com.natasatm.restaurant.dto.MenuItemEntityDto;
import com.natasatm.restaurant.model.MenuEntity;
import com.natasatm.restaurant.model.MenuEntityCategory;
import com.natasatm.restaurant.repository.MenuEntityRepository;
import com.natasatm.restaurant.service.MenuEntityCategoryService;
import com.natasatm.restaurant.service.MenuEntityService;
import com.natasatm.restaurant.service.MenuItemEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuController {
    private MenuItemEntityService menuItemEntityService;
    private MenuEntityCategoryService menuEntityCategoryService;
    private MenuEntityService menuEntityService;

    @Autowired
    public MenuController(MenuItemEntityService menuItemEntityService, MenuEntityCategoryService menuEntityCategoryService,MenuEntityService menuEntityService) {
        this.menuItemEntityService = menuItemEntityService;
        this.menuEntityCategoryService = menuEntityCategoryService;
        this.menuEntityService = menuEntityService;
    }

    @GetMapping("/menuItem-create.html")
    public String createMenuItemForm(Model model) {
        MenuItemEntityDto menuItem = new MenuItemEntityDto();
        List<MenuEntityCategory> menuCategories = menuEntityCategoryService.getAllCategories();
        model.addAttribute("menuItem", menuItem);
        model.addAttribute("menuCategories", menuCategories);
        return "menuItem-create2";
    }

    @PostMapping("/menuItem-create.html")
    public String saveMenuItem(@ModelAttribute MenuItemEntityDto menuItem) {

        menuItemEntityService.addMenuItem(menuItem);
        return "redirect:/menu.html";
    }

    @GetMapping("/menu.html")
    public String menuItemsList(Model model) {
        MenuEntityDto menuDto = menuEntityService.getMenuByName("Main menu");
        List<MenuItemEntityDto> menuItems = menuDto.getMenuItems();
        List<MenuEntityCategory> menuCategories = menuEntityCategoryService.getAllCategories();
        model.addAttribute("menuItems", menuItems);
        model.addAttribute("menuCategories", menuCategories);
        return "menu";
    }

    @GetMapping("/menuItem-edit.html")
    public String updateMenuItem(@RequestParam("menuItemId") Long menuItemId,Model model) {

        MenuItemEntityDto menuItem = menuItemEntityService.findById(menuItemId);
        List<MenuEntityCategory> menuCategories = menuEntityCategoryService.getAllCategories();
        System.out.println(menuItem);
       model.addAttribute("menuItem", menuItem);
        model.addAttribute("menuCategories", menuCategories);
        return "menuItem-edit";
    }
    @PostMapping("/menuItem-edit.html")
    public String updateMenuItem(@ModelAttribute MenuItemEntityDto menuItem){
        menuItemEntityService.addMenuItem(menuItem);
        return "redirect:/menu.html";
    }
    @GetMapping("/menuItem-delete.html")
    public String deleteMenuItem(@RequestParam("menuItemId") Long menuItemId){
        menuItemEntityService.deleteById(menuItemId);
        return "redirect:/menu.html";
    }

    @PostMapping("menu-add.html")
    public String createMenu(@ModelAttribute MenuEntityDto menuEntityDto){
        menuEntityService.addMenu(menuEntityDto);
        return "redirect:/menu.html";

    }


}
