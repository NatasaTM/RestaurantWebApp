package com.natasatm.restaurant.service;

import com.natasatm.restaurant.dto.RegistrationDto;
import com.natasatm.restaurant.model.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
