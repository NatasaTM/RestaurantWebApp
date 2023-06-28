package com.natasatm.restaurant.controller;

import com.natasatm.restaurant.dto.RegistrationDto;
import com.natasatm.restaurant.model.UserEntity;
import com.natasatm.restaurant.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public String getLoginForm(){
        return "login";
    }
    @GetMapping("/register")
    public String getRegisterForm(Model model){
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute(registrationDto);
        return "register";
    }
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user")RegistrationDto user, BindingResult result, Model model){
        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
        if(existingUserEmail !=null && existingUserEmail.getEmail() !=null && !existingUserEmail.getEmail().isEmpty()){
            return "redirect:/register?fail";

        }
        UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
        if(existingUserUsername !=null && existingUserUsername.getUsername() !=null && !existingUserUsername.getUsername().isEmpty()){
            return "redirect:/register?fail";

        }
        if(result.hasErrors()){
            model.addAttribute("user,user");
            return "/register";
        }
        userService.saveUser(user);
        return "redirect:/index.html?success";

    }

}