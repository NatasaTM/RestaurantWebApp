package com.natasatm.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookTableController {

    @GetMapping("/book.html")
    public String bookTableForm(){
        return "book2";
    }

}
