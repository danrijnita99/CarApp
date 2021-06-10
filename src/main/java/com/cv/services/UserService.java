package com.cv.services;

import com.cv.dtos.UserDTO;
import com.cv.entities.User;
import com.cv.exceptions.UserAlreadyExistingException;
import com.cv.exceptions.UserDoesNotExistException;
import com.cv.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(UserDTO newUser) throws UserAlreadyExistingException {
       User user =  userRepository.findByUsername(newUser.getUsername());

       if (user != null) {
           throw new UserAlreadyExistingException();
       }

       User newCreatedUser = User.builder()
               .username(newUser.getUsername())
              // .password(passwordEncoder.encode(newUser.getPassword()))
               .password(newUser.getPassword())
               .email(newUser.getEmail())
               .firstName(newUser.getFirstName())
               .lastName(newUser.getLastName())
               .active(newUser.getActive())
               .build();

       return userRepository.saveAndFlush(newCreatedUser);
    }
    public User oneUser(Long id) throws UserDoesNotExistException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserDoesNotExistException());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) throws UserDoesNotExistException {
        userRepository.deleteById(id);
    }
}
