package com.natasatm.restaurant.service.impl;

import com.natasatm.restaurant.model.MenuEntityCategory;
import com.natasatm.restaurant.repository.MenuEntityCategoryRepository;
import com.natasatm.restaurant.service.MenuEntityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuEntityCategoryServiceImpl implements MenuEntityCategoryService {
    private MenuEntityCategoryRepository menuEntityCategoryRepository;
    @Autowired
    public MenuEntityCategoryServiceImpl(MenuEntityCategoryRepository menuEntityCategoryRepository) {
        this.menuEntityCategoryRepository = menuEntityCategoryRepository;
    }



    @Override
    public List<MenuEntityCategory> getAllCategories() {
        return menuEntityCategoryRepository.findAll();
    }


}
