package com.cv.controllers;

import com.cv.dtos.UserDTO;
import com.cv.entities.User;
import com.cv.exceptions.UserAlreadyExistingException;
import com.cv.exceptions.UserDoesNotExistException;
import com.cv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User one(@PathVariable Long id) throws UserDoesNotExistException {
        return userService.oneUser(id);
    }
    @GetMapping("/users")
    public List<User> all() {
        return userService.allUsers();
    }

    @PostMapping("/users")
    public User newUser(@RequestBody UserDTO newUser) throws UserAlreadyExistingException {
        return userService.save(newUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) throws UserDoesNotExistException {
        userService.deleteUser(id);
    }

}
