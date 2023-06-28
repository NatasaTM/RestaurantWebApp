package com.natasatm.restaurant.repository;

import com.natasatm.restaurant.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);

    UserEntity findFirstByUsername(String username);
}
