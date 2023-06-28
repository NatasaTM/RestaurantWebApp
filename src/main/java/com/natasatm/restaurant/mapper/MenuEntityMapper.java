package com.natasatm.restaurant.mapper;

import com.natasatm.restaurant.dto.MenuEntityDto;
import com.natasatm.restaurant.dto.MenuItemEntityDto;
import com.natasatm.restaurant.model.MenuEntity;
import com.natasatm.restaurant.model.MenuItemEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.natasatm.restaurant.mapper.MenuItemEntityMapper.mapToMenuItemEntity;
import static com.natasatm.restaurant.mapper.MenuItemEntityMapper.mapToMenuItemEntityDto;

public class MenuEntityMapper {

    public static MenuEntityDto mapToMenuEntityDto(MenuEntity menu) {
        List<MenuItemEntityDto> menuItemsDto = menu.getMenuItems().stream()
                .map(menuItemEntity -> mapToMenuItemEntityDto(menuItemEntity))
                .collect(Collectors.toList());
        MenuEntityDto menuDto = MenuEntityDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .isActive(menu.isActive())
                .menuItems(menuItemsDto)
                .build();
        return menuDto;

    }

    public static MenuEntity mapToMenuEntity(MenuEntityDto menuDto) {
        List<MenuItemEntity> menuItems = new ArrayList<>();
        if(menuDto.getMenuItems() !=null){
             menuItems = menuDto.getMenuItems().stream().map(menuItemEntityDto -> mapToMenuItemEntity(menuItemEntityDto)).collect(Collectors.toList());
        }

        MenuEntity menu = MenuEntity.builder()
                .id(menuDto.getId())
                .name(menuDto.getName())
                .isActive(menuDto.isActive())
                .menuItems(menuItems)
                .build();
        return menu;
    }

}
