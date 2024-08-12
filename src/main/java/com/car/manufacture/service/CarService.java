package com.car.manufacture.service;
import java.util.LinkedHashSet;

public interface CarService <T>{
    LinkedHashSet<T> getAllCars();
    T getById(long id);
    void remove(long id);
    T getCarByBrand(String brand);
    T insert(T obj);
    LinkedHashSet<String> getAllEngineerByCarId(Long car_id);
    LinkedHashSet<String> getAllEngineerByBrand(String brand) throws Exception;
}
