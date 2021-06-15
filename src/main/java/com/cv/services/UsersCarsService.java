package com.cv.services;

import com.cv.dtos.UsersCarsDTO;
import com.cv.entities.Car;
import com.cv.entities.User;
import com.cv.entities.UsersCars;
import com.cv.exceptions.CarDoesNotExistException;
import com.cv.exceptions.UserDoesNotExistException;
import com.cv.repositories.UsersCarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersCarsService {
    @Autowired
    private UsersCarsRepository usersCarsRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CarsService carsService;

    public UsersCars acquireCar(UsersCarsDTO usersCarsDTO) throws UserDoesNotExistException, CarDoesNotExistException {
        User user = userService.oneUser(usersCarsDTO.getUserId());
        Car car = carsService.oneCar(usersCarsDTO.getCarId());
        UsersCars newEntity = UsersCars.builder()
                .user(user)
                .car(car)
                .build();
        UsersCars result = usersCarsRepository.save(newEntity);
        return result;
    }

    public List<UsersCars> getAllUsersCars(Long userId) throws UserDoesNotExistException {
        User user = userService.oneUser(userId);
        return usersCarsRepository.findByUser(user);
    }
}
