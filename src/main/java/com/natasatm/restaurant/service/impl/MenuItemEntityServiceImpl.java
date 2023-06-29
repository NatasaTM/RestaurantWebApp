package com.natasatm.restaurant.service.impl;

import com.natasatm.restaurant.dto.MenuItemDto;
import com.natasatm.restaurant.model.MenuItem;
import com.natasatm.restaurant.repository.MenuItemRepository;
import com.natasatm.restaurant.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static com.natasatm.restaurant.mapper.MenuItemMapper.mapToMenuItemEntity;
import static com.natasatm.restaurant.mapper.MenuItemMapper.mapToMenuItemEntityDto;

@Service
public class MenuItemEntityServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemEntityServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }


    @Override
    public void addMenuItem(MenuItemDto menuItemDto) {
        menuItemRepository.save(mapToMenuItemEntity(menuItemDto));
    }


    @Override
    public List<MenuItemDto> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        List<MenuItemDto> menuItemsDto = new ArrayList<>();
        for (MenuItem mi : menuItems) {
            MenuItemDto miDto = mapToMenuItemEntityDto(mi);
            menuItemsDto.add(miDto);

        }
        return menuItemsDto;
    }

    @Override
    public MenuItemDto findById(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id).get();
        MenuItemDto menuItemDto = mapToMenuItemEntityDto(menuItem);
        return menuItemDto;

    }

    @Override
    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }
}
