package com.cv.controllers;

import com.cv.dtos.CarDTO;
import com.cv.entities.Car;
import com.cv.exceptions.CarDoesNotExistException;
import com.cv.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarsService carsService;
    CarController(CarsService carsService) {
        this.carsService = carsService;
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody CarDTO newCar) {
        return carsService.insert(newCar);
    }

//    @GetMapping("/cars/model/{model}")
//    public List<Car> searchCarModel(@PathVariable String model) throws CarDoesNotExistException {
//        return carsService.searchCarModel(model);
//    }

    @GetMapping("/cars/brand/{brand}")
    public List<Car> searchCarBrand(@PathVariable String brand) throws CarDoesNotExistException {
        return carsService.searchCarBrand(brand);
    }


    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carsService.getAllCars();
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) throws CarDoesNotExistException {
        carsService.deleteCar(id);
    }
}
