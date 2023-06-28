package com.natasatm.restaurant.service;


import com.natasatm.restaurant.dto.MenuEntityDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MenuEntityService {

    MenuEntityDto getMenuEntity();

    List<MenuEntityDto> getAllMenus();

    void addMenu(MenuEntityDto menuEntityDto);

    MenuEntityDto getMenuByName(String name);


}
