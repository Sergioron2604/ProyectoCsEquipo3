package com.example.ProyectoCs.infrastructure.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "Please login with your credentials.";
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "Login successful!";
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "There was an error with your login attempt. Please try again.";
    }
}
