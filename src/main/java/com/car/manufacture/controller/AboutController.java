package com.car.manufacture.controller;

import com.car.manufacture.entities.Car;
import com.car.manufacture.service.CarServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.time.LocalDateTime;

@RestController
@RequestMapping
public final class AboutController {
    protected CarServiceImpl carService;
    AppLogger logger;
    @Autowired
    public AboutController(CarServiceImpl carService) {
        this.carService = carService;
        logger = new AppLogger();
        logger.log(Level.INFO, "Successfully initialized Spring application", this.getClass().getName());
    }
    @GetMapping
    public ResponseEntity<String> about() {
        return ResponseEntity.ok().body("Hello from Spring Boot Basics! Time: " + LocalDateTime.now());
    }
    @GetMapping("engineers/{brand}")
    public ResponseEntity<LinkedHashSet<String>> getEngineersByBrand(@PathVariable String brand) throws NullPointerException{
        logger.log(Level.INFO, "Received request list of engineers brand:"+brand, this.getClass().getName());
        Car car = carService.getCarByBrand(brand);
        Long id = car.getCar_id();
        return new ResponseEntity<>(carService.getAllEngineerByCarId(id), HttpStatus.OK);
    }
    @GetMapping("/cars")
    public ResponseEntity<LinkedHashSet<Car>> getAllCars() throws NullPointerException{
        logger.log(Level.INFO, "Received GET request for list of cars", this.getClass().getName());
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }
    @GetMapping("/car/{brand}")
    public ResponseEntity <Car> getAllCarByBrand(@PathVariable String brand) throws NullPointerException{
        logger.log(Level.INFO, "Received GET request car by brand", this.getClass().getName());
        return new ResponseEntity<>(carService.getCarByBrand(brand), HttpStatus.OK);
    }
    @GetMapping("/car/engineers/{car_id}")
    public ResponseEntity <LinkedHashSet<String>> getAllEngineerByCarId(@PathVariable Long car_id)  throws NullPointerException{
        logger.log(Level.INFO, "Received GET request for list of engineers", this.getClass().getName());
        return new ResponseEntity<>(carService.getAllEngineerByCarId(car_id), HttpStatus.OK);
    }
    @GetMapping("/cars/{car_id}")
    public ResponseEntity<Car> get_by_id(@PathVariable Long car_id) throws NullPointerException{
        logger.log(Level.INFO, "Received request car id:"+carService.getById(car_id), this.getClass().getName());
        return new ResponseEntity<>(carService.getById(car_id), HttpStatus.OK);
    }
    @DeleteMapping("/removeCar/{car_id}")
    public void removeStudent(@PathVariable Long car_id) {
        logger.log(Level.INFO, "Received DELETE car by id" + car_id, this.getClass().getName());
        carService.remove(car_id);
    }
}