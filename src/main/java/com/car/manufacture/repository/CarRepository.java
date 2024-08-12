package com.car.manufacture.repository;

import com.car.manufacture.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long>{
    Car getCarByBrand(String brand);
}
