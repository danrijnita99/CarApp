package com.cv.services;

import com.cv.dtos.UserDTO;
import com.cv.entities.User;
import com.cv.exceptions.UserAlreadyExistsException;
import com.cv.exceptions.UserDoesNotExistException;
import com.cv.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO newUser) throws UserAlreadyExistsException {
       User user =  userRepository.findByUsername(newUser.getUsername());

       if (user != null) {
           throw new UserAlreadyExistsException("User" + user.getUsername() + " already exists!");
       }

       User newCreatedUser = User.builder()
               .username(newUser.getUsername())
               .password(newUser.getPassword())
               .email(newUser.getEmail())
               .firstName(newUser.getFirstName())
               .lastName(newUser.getLastName())
               .active(newUser.getActive())
               .build();

       return userRepository.save(newCreatedUser);
    }
    public User oneUser(Long id) throws UserDoesNotExistException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserDoesNotExistException("User with id " + id + " does not exist!"));
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) throws UserDoesNotExistException {
        userRepository.deleteById(id);
    }
}
