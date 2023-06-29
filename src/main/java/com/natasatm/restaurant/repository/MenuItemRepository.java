package com.natasatm.restaurant.repository;

import com.natasatm.restaurant.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
    MenuItem findByName(String name);
}
