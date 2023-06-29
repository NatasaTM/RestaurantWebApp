package com.natasatm.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {
    @GetMapping("/shoppingCart.html")
    public String getShoppingCartForm(){
        return "shopping-cart";
    }
}
