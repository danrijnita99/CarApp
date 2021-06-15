package com.cv.controllers;

import com.cv.dtos.UsersCarsDTO;
import com.cv.entities.UsersCars;
import com.cv.exceptions.CarDoesNotExistException;
import com.cv.exceptions.UserDoesNotExistException;
import com.cv.services.UsersCarsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(path = "/usersCars")
public class UsersCarsController {

    @Autowired
    private UsersCarsService usersCarsService;

    @PostMapping
    public ResponseEntity<?> acquireCar(@RequestBody @Valid UsersCarsDTO usersCarsDTO) throws UserDoesNotExistException, CarDoesNotExistException {
        log.info("Received POST /usersCars | usersCarsDTO = {}", usersCarsDTO);

        UsersCars usersCars = usersCarsService.acquireCar(usersCarsDTO);

        log.info("Responded POST /usersCars | usersCars = {}", usersCars);
        return new ResponseEntity<>(usersCars, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllUsersCars(@PathVariable Long userId) throws UserDoesNotExistException {
        log.info("Received POST /usersCars | usersCarsDTO = {}", userId);

        List<UsersCars> usersCars =  usersCarsService.getAllUsersCars(userId);

        log.info("Responded POST /usersCars | usersCars = {}", userId);
        return new ResponseEntity<>(usersCars, HttpStatus.OK);
    }
}
