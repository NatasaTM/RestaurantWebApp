package com.natasatm.restaurant.service.impl;

import com.natasatm.restaurant.dto.MenuEntityDto;
import com.natasatm.restaurant.dto.MenuItemEntityDto;
import com.natasatm.restaurant.model.MenuEntity;
import com.natasatm.restaurant.model.MenuItemEntity;
import com.natasatm.restaurant.repository.MenuEntityRepository;
import com.natasatm.restaurant.repository.MenuItemEntityRepository;
import com.natasatm.restaurant.service.MenuItemEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.natasatm.restaurant.mapper.MenuEntityMapper.mapToMenuEntity;
import static com.natasatm.restaurant.mapper.MenuItemEntityMapper.mapToMenuItemEntity;
import static com.natasatm.restaurant.mapper.MenuItemEntityMapper.mapToMenuItemEntityDto;

@Service
public class MenuItemEntityServiceImpl implements MenuItemEntityService {
    private MenuEntityRepository menuEntityRepository;
    private MenuItemEntityRepository menuItemEntityRepository;

    @Autowired
    public MenuItemEntityServiceImpl(MenuEntityRepository menuEntityRepository, MenuItemEntityRepository menuItemEntityRepository) {
        this.menuEntityRepository = menuEntityRepository;
        this.menuItemEntityRepository = menuItemEntityRepository;
    }

    @Override
    public List<MenuItemEntityDto> getMenuItemsByMenuId(Long id) {
        MenuEntity menu = menuEntityRepository.findById(id).get();
        List<MenuItemEntity> menuItems = menu.getMenuItems();
        List<MenuItemEntityDto> menuItemsDto = menuItems.stream().map(menuItemEntity -> mapToMenuItemEntityDto(menuItemEntity)).collect(Collectors.toList());

        return menuItemsDto;
    }

    @Override
    public void addMenuItemsToMenu(MenuEntityDto menuDto, List<MenuItemEntityDto> menuItemEntitiesDto) {
        MenuEntity menu = mapToMenuEntity(menuDto);

        List<MenuItemEntity> menuItems = new ArrayList<>();
        for (MenuItemEntityDto m : menuItemEntitiesDto
        ) {
            MenuItemEntity mi = mapToMenuItemEntity(m);
            menuItems.add(mi);

        }
        menu.setMenuItems(menuItems);
        menuEntityRepository.save(menu);
    }

    @Override
    public void addMenuItem(MenuItemEntityDto menuItemDto) {
        menuItemEntityRepository.save(mapToMenuItemEntity(menuItemDto));
    }

    @Override
    public void addMenuItemToMenu(MenuEntityDto menuDto, MenuItemEntityDto menuItemEntityDto) {
        MenuEntity menu = mapToMenuEntity(menuDto);
        menu.getMenuItems().add(mapToMenuItemEntity(menuItemEntityDto));
        menuEntityRepository.save(menu);
    }

    @Override
    public List<MenuItemEntityDto> getAllMenuItems() {
        List<MenuItemEntity> menuItems = menuItemEntityRepository.findAll();
        List<MenuItemEntityDto> menuItemsDto = new ArrayList<>();
        for (MenuItemEntity mi : menuItems
        ) {
            MenuItemEntityDto miDto = mapToMenuItemEntityDto(mi);
            menuItemsDto.add(miDto);

        }
        return menuItemsDto;
    }

    @Override
    public MenuItemEntityDto findById(Long id) {
        MenuItemEntity menuItem = menuItemEntityRepository.findById(id).get();
        MenuItemEntityDto menuItemDto = mapToMenuItemEntityDto(menuItem);
        return menuItemDto;

    }

    @Override
    public void deleteById(Long id) {
        menuItemEntityRepository.deleteById(id);
    }
}
