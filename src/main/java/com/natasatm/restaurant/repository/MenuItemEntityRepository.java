package com.natasatm.restaurant.repository;

import com.natasatm.restaurant.model.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemEntityRepository extends JpaRepository<MenuItemEntity,Long> {
}
