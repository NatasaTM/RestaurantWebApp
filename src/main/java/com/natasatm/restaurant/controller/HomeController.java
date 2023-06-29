package com.natasatm.restaurant.controller;


import com.natasatm.restaurant.dto.MenuItemDto;
import com.natasatm.restaurant.model.MenuEntityCategory;
import com.natasatm.restaurant.service.MenuItemCategoryService;
import com.natasatm.restaurant.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller

public class HomeController {

    private MenuItemService menuItemService;
    private MenuItemCategoryService menuItemCategoryService;

    @Autowired
    public HomeController(MenuItemService menuItemEntityService, MenuItemCategoryService menuEntityCategoryService) {

        this.menuItemService = menuItemEntityService;
        this.menuItemCategoryService = menuEntityCategoryService;
    }

    @GetMapping("/index.html")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<MenuItemDto> menuItems = menuItemService.getAllMenuItems().stream().filter(menuItemDto -> menuItemDto.getActive()==true).collect(Collectors.toList());
        List<MenuEntityCategory> menuCategories = menuItemCategoryService.getAllCategories();

                modelAndView.addObject("menuItems", menuItems);
                modelAndView.addObject("menuCategories",menuCategories);
        return modelAndView;

    }
}
