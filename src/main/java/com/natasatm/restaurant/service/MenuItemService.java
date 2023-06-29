package com.natasatm.restaurant.service;

import com.natasatm.restaurant.dto.MenuItemDto;

import java.util.List;

public interface MenuItemService {





    void addMenuItem(MenuItemDto menuItemDto);



    List<MenuItemDto> getAllMenuItems();

    MenuItemDto findById(Long id);

    void deleteById(Long id);





}
