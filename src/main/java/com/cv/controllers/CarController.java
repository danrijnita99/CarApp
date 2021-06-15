package com.cv.controllers;

import com.cv.dtos.CarDTO;
import com.cv.entities.Car;
import com.cv.exceptions.CarDoesNotExistException;
import com.cv.services.CarsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
public class CarController {
    @Autowired
    private CarsService carsService;


    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody @Valid CarDTO newCar) {
        log.info("Received POST /cars | CarDTO = {}", newCar);

        Car car = carsService.insert(newCar);

        log.info("Responded POST /cars | Car = {}", car);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("/cars/brand/{brand}")
    public List<Car> searchCarBrand(@PathVariable String brand) throws CarDoesNotExistException {
        log.info("Received POST /cars/brand/{brand} | brand = {}", brand);

        List<Car> cars = carsService.searchCarBrand(brand);

        log.info("Responded POST /cars/brand/{brand} | cars = {}", cars);
        return cars;

    }


    @GetMapping("/cars")
    public List<Car> getAllCars() {
        log.info("Received POST /cars");

        List<Car> cars = carsService.getAllCars();

        log.info("Responded POST /cars | cars = {}", cars);
        return cars;

    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) throws CarDoesNotExistException {
        log.info("DELETE /cars/{id} | id = {}", id);

        carsService.deleteCar(id);
    }
}
