package com.portafolio.backend.portafolio_backend.mvc_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; 
    }

   

}
