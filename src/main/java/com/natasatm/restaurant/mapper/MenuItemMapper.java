package com.natasatm.restaurant.mapper;

import com.natasatm.restaurant.dto.MenuItemDto;
import com.natasatm.restaurant.model.MenuItem;

public class MenuItemMapper {

    public static MenuItemDto mapToMenuItemEntityDto(MenuItem menuItemEntity){
        MenuItemDto menuItemDto = MenuItemDto.builder()
                .id(menuItemEntity.getId())
                .name(menuItemEntity.getName())
                .description(menuItemEntity.getDescription())
                .active(menuItemEntity.getActive())
                .price(menuItemEntity.getPrice())
                .menuCategory(menuItemEntity.getMenuCategory())
                .pictureUrl(menuItemEntity.getPictureUrl())
                .build();
        return menuItemDto;
    }
    public static MenuItem mapToMenuItemEntity(MenuItemDto menuItemEntityDto){
        MenuItem menuItem = MenuItem.builder()
                .id(menuItemEntityDto.getId())
                .name(menuItemEntityDto.getName())
                .description(menuItemEntityDto.getDescription())
                .active(menuItemEntityDto.getActive())
                .price(menuItemEntityDto.getPrice())
                .menuCategory(menuItemEntityDto.getMenuCategory())
                .pictureUrl(menuItemEntityDto.getPictureUrl())
                .build();
        return menuItem;
    }
}
