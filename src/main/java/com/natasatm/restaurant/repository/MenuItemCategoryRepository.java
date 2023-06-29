package com.natasatm.restaurant.repository;

import com.natasatm.restaurant.model.MenuEntityCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemCategoryRepository extends JpaRepository<MenuEntityCategory,Long> {

}
