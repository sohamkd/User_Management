package com.usermanagement.service;

import com.usermanagement.dtos.AuthResponse;
import com.usermanagement.dtos.LoginRequest;
import com.usermanagement.dtos.RegisterRequest;
import com.usermanagement.entities.Role;
import com.usermanagement.entities.User;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest request)
    {
        if (userRepository.findByEmail(request.getEmail()).isPresent())
        {
            return new AuthResponse(null,"Email already successfully.");
        }

        User user=User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singleton(Role.ROLE_USER))
                .build();

        userRepository.save(user);

        String token= jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token,"User Registered Successfully.");
    }

    public AuthResponse login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            return new AuthResponse(null, "Invalid email or password");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse(null, "Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, "Login successful");
    }

}
