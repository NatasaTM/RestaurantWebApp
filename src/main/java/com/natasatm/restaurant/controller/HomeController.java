package com.natasatm.restaurant.controller;


import com.natasatm.restaurant.dto.MenuItemEntityDto;
import com.natasatm.restaurant.model.MenuEntityCategory;
import com.natasatm.restaurant.service.MenuEntityCategoryService;
import com.natasatm.restaurant.service.MenuEntityService;
import com.natasatm.restaurant.service.MenuItemEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class HomeController {
    private MenuEntityService menuEntityService;
    private MenuItemEntityService menuItemEntityService;
    private MenuEntityCategoryService menuEntityCategoryService;

    @Autowired
    public HomeController(MenuEntityService menuEntityService, MenuItemEntityService menuItemEntityService, MenuEntityCategoryService menuEntityCategoryService) {
        this.menuEntityService = menuEntityService;
        this.menuItemEntityService = menuItemEntityService;
        this.menuEntityCategoryService = menuEntityCategoryService;
    }

    @GetMapping("/index.html")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<MenuItemEntityDto> menuItems = menuItemEntityService.getAllMenuItems();
        List<MenuEntityCategory> menuCategories = menuEntityCategoryService.getAllCategories();

                modelAndView.addObject("menuItems", menuItems);
                modelAndView.addObject("menuCategories",menuCategories);
        return modelAndView;

    }
}
