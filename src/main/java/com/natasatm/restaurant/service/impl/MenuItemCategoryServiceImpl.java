package com.natasatm.restaurant.service.impl;

import com.natasatm.restaurant.model.MenuEntityCategory;
import com.natasatm.restaurant.repository.MenuItemCategoryRepository;
import com.natasatm.restaurant.service.MenuItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemCategoryServiceImpl implements MenuItemCategoryService {
    private MenuItemCategoryRepository menuEntityCategoryRepository;
    @Autowired
    public MenuItemCategoryServiceImpl(MenuItemCategoryRepository menuEntityCategoryRepository) {
        this.menuEntityCategoryRepository = menuEntityCategoryRepository;
    }



    @Override
    public List<MenuEntityCategory> getAllCategories() {
        return menuEntityCategoryRepository.findAll();
    }


}
