package com.usermanagement.controller;

import com.usermanagement.dtos.AuthResponse;
import com.usermanagement.dtos.LoginRequest;
import com.usermanagement.dtos.RegisterRequest;
import com.usermanagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request)
    {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request)
    {
        return authService.login(request);
    }


}
