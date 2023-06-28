package com.natasatm.restaurant.repository;

import com.natasatm.restaurant.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuEntityRepository extends JpaRepository<MenuEntity,Long> {
    MenuEntity findByName(String name);
}
