package com.natasatm.restaurant.service;

import com.natasatm.restaurant.dto.MenuItemDto;

import java.util.List;

public interface MenuItemEntityService {

    List<MenuItemDto> getMenuItemsByMenuId(Long id);

    void addMenuItemsToMenu(MenuEntityDto menu, List<MenuItemDto> menuItemEntitiesDto);

    void addMenuItem(MenuItemDto menuItemDto);

    void addMenuItemToMenu(MenuEntityDto menu, MenuItemDto menuItemEntityDto);

    List<MenuItemDto> getAllMenuItems();

    MenuItemDto findById(Long id);

    void deleteById(Long id);





}
