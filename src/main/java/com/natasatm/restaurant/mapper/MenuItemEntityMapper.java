package com.natasatm.restaurant.mapper;

import com.natasatm.restaurant.dto.MenuItemEntityDto;
import com.natasatm.restaurant.model.MenuItemEntity;

public class MenuItemEntityMapper {

    public static MenuItemEntityDto mapToMenuItemEntityDto(MenuItemEntity menuItemEntity){
        MenuItemEntityDto menuItemDto = MenuItemEntityDto.builder()
                .id(menuItemEntity.getId())
                .name(menuItemEntity.getName())
                .description(menuItemEntity.getDescription())
                .price(menuItemEntity.getPrice())
                .menuCategory(menuItemEntity.getMenuCategory())
                .pictureUrl(menuItemEntity.getPictureUrl())
                .build();
        return menuItemDto;
    }
    public static MenuItemEntity mapToMenuItemEntity(MenuItemEntityDto menuItemEntityDto){
        MenuItemEntity menuItem = MenuItemEntity.builder()
                .id(menuItemEntityDto.getId())
                .name(menuItemEntityDto.getName())
                .description(menuItemEntityDto.getDescription())
                .price(menuItemEntityDto.getPrice())
                .menuCategory(menuItemEntityDto.getMenuCategory())
                .pictureUrl(menuItemEntityDto.getPictureUrl())
                .build();
        return menuItem;
    }
}
