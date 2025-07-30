package com.usermanagement.controller;

import com.usermanagement.entities.User;
import com.usermanagement.exception.ResourceNotFoundException;
import com.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id)
    {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with given id"+ id));

    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id)
    {
        boolean exists = userRepository.existsById(id);

        if (exists) {
            userRepository.deleteById(id);
            return "User deleted successfully.";
        } else {
            throw new ResourceNotFoundException("User not found with given id:"+id);
        }
    }
}
