package com.natasatm.restaurant.dto;

import com.natasatm.restaurant.model.MenuEntityCategory;
import com.natasatm.restaurant.model.MenuItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuEntityDto {

    private Long id;
    private String name;
    private boolean isActive;

    private List<MenuItemEntityDto> menuItems;
}
