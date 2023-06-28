package com.natasatm.restaurant.service.impl;

import com.natasatm.restaurant.dto.MenuEntityDto;
import com.natasatm.restaurant.model.MenuEntity;
import com.natasatm.restaurant.repository.MenuEntityRepository;
import com.natasatm.restaurant.service.MenuEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.natasatm.restaurant.mapper.MenuEntityMapper.mapToMenuEntity;
import static com.natasatm.restaurant.mapper.MenuEntityMapper.mapToMenuEntityDto;
@Service
public class MenuEntityServiceImpl implements MenuEntityService {

    private MenuEntityRepository menuEntityRepository;
    @Autowired
    public MenuEntityServiceImpl(MenuEntityRepository menuEntityRepository) {
        this.menuEntityRepository = menuEntityRepository;
    }

    @Override
    public MenuEntityDto getMenuEntity() {

        return null;
    }

    @Override
    public List<MenuEntityDto> getAllMenus() {
        List<MenuEntityDto> menus = menuEntityRepository.findAll().stream().map(menu -> mapToMenuEntityDto(menu)).collect(Collectors.toList());
        return menus;
    }

    @Override
    public void addMenu(MenuEntityDto menuEntityDto) {
        MenuEntity menu = mapToMenuEntity(menuEntityDto);
        menuEntityRepository.save(menu);

    }

    @Override
    public MenuEntityDto getMenuByName(String name) {
        MenuEntity m = menuEntityRepository.findByName(name);

        return mapToMenuEntityDto(m);
    }
}
