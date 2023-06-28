package com.natasatm.restaurant.service;

import com.natasatm.restaurant.dto.MenuEntityDto;
import com.natasatm.restaurant.dto.MenuItemEntityDto;

import com.natasatm.restaurant.model.MenuItemEntity;

import java.util.List;

public interface MenuItemEntityService {

    List<MenuItemEntityDto> getMenuItemsByMenuId(Long id);

    void addMenuItemsToMenu(MenuEntityDto menu, List<MenuItemEntityDto> menuItemEntitiesDto);

    void addMenuItem(MenuItemEntityDto menuItemDto);

    void addMenuItemToMenu(MenuEntityDto menu, MenuItemEntityDto menuItemEntityDto);

    List<MenuItemEntityDto> getAllMenuItems();

    MenuItemEntityDto findById(Long id);

    void deleteById(Long id);





}
