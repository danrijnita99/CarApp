package com.cv.services;

import com.cv.dtos.CarDTO;
import com.cv.entities.Car;
import com.cv.exceptions.CarDoesNotExistException;
import com.cv.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    @Autowired
    private CarRepository carRepository;


    public Car insert(CarDTO newCar) {
        Car newCreatedCar = Car.builder()
                .brand(newCar.getBrand())
                .model(newCar.getModel())
                .price(newCar.getPrice())
                .available(newCar.getAvailable())
                .build();

        return carRepository.saveAndFlush(newCreatedCar);
    }

    public List<Car> searchCarBrand(String brand) throws CarDoesNotExistException {
        List<Car> searchedCar = carRepository.findByBrand(brand);

        if (searchedCar.isEmpty() == true) {
            throw(new CarDoesNotExistException());
        } else {
            return searchedCar;
        }
    }

//    public List<Car> searchCarModel(String model) throws CarDoesNotExistException {
//        List<Car> searchedCar = carRepository.findByModel(model);
//
//        if (searchedCar.isEmpty() == true) {
//            throw(new CarDoesNotExistException());
//        } else {
//            return searchedCar;
//        }
//    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void deleteCar(Long id) throws CarDoesNotExistException {
        carRepository.deleteById(id);
    }
}
