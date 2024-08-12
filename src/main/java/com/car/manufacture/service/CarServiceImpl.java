package com.car.manufacture.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.car.manufacture.entities.Car;
import com.car.manufacture.entities.Engineer;
import com.car.manufacture.repository.CarRepository;
import com.car.manufacture.repository.EngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarServiceImpl implements CarService <Car>{
    @Autowired
    private EngineerRepository engineerRepository;
    @Autowired
    private CarRepository carRepository;
    ObjectMapper objectMapper;
    @Autowired
    public CarServiceImpl(EngineerRepository engineerRepository, CarRepository carRepository, ObjectMapper objectMapper) {
        this.engineerRepository = engineerRepository;
        this.carRepository = carRepository;
        this.objectMapper = objectMapper;
    }
    @Override
    public LinkedHashSet<Car> getAllCars() {
        LinkedHashSet<Car> cars = new LinkedHashSet<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car getById(long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public void remove(long car_id) {
        carRepository.deleteById(car_id);
    }

    @Override
    public Car getCarByBrand(String brand) {
        return carRepository.getCarByBrand(brand);
    }

    @Override
    public Car insert(Car car) {
        return carRepository.save(car);
    }

    @Override
    public LinkedHashSet<String> getAllEngineerByCarId(Long car_id) {
        LinkedHashSet<String> engineers = new LinkedHashSet<>();
        for(Engineer engineer : engineerRepository.findAll()){
            if(engineer.getCar_id() == car_id){
                engineers.add(engineer.getName());
            }
        }
        return engineers;
    }

    @Override
    public LinkedHashSet<String> getAllEngineerByBrand(String brand) {
        LinkedHashSet<String> engineers;
        long car_id = 0;
        for (Car car : carRepository.findAll()) {
            if (car.getBrand() == brand) {
                car_id = car.getCar_id();
            }
        }
        engineers = getAllEngineerByCarId(car_id);
        return engineers;
    }
}