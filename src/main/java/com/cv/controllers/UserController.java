package com.cv.controllers;

import com.cv.dtos.UserDTO;
import com.cv.entities.User;
import com.cv.exceptions.UserAlreadyExistsException;
import com.cv.exceptions.UserDoesNotExistException;
import com.cv.services.UserService;
import liquibase.pro.packaged.U;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> one(@PathVariable Long id) throws UserDoesNotExistException {
        log.info("Received GET /users | id = {}", id);

        User user = userService.oneUser(id);

        log.info("Responded GET /users | user = {}", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/users")
    public List<User> all() {
        log.info("Received GET /users");

        List<User> users = userService.allUsers();

        log.info("Responded GET /users | users = {}", users);
        return users;
    }

    @PostMapping("/users")
    public ResponseEntity<?> newUser(@RequestBody @Valid UserDTO newUser) throws UserAlreadyExistsException {
        log.info("Received POST /users | UserDTO = {}", newUser);

        User user = userService.save(newUser);

        log.info("Responded POST /users | user = {}", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws UserDoesNotExistException {
        log.info("Received DELETE /users/{id} | id = {}", id);

        userService.deleteUser(id);

        log.info("Responded DELETE /users/{id} | id = {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
