package com.natasatm.restaurant.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDto {


        private Long id;
        @NotEmpty
        private String username;
        @NotEmpty
        private String email;
        @NotEmpty
        private String password;

}
