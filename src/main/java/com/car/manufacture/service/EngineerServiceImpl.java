package com.car.manufacture.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.car.manufacture.entities.Engineer;
import com.car.manufacture.repository.CarRepository;
import com.car.manufacture.repository.EngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashSet;

public class EngineerServiceImpl implements EngineerService<Engineer> {
    @Autowired
    private EngineerRepository engineerRepository;
    @Autowired
    private CarRepository carRepository;
    ObjectMapper objectMapper;
    @Autowired
    public EngineerServiceImpl(EngineerRepository engineerRepository, CarRepository carRepository, ObjectMapper objectMapper) {
        this.engineerRepository = engineerRepository;
        this.carRepository = carRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public LinkedHashSet<Engineer> getAllEngineers() {
        LinkedHashSet<Engineer> engineers  = new LinkedHashSet<>();
        engineerRepository.findAll().forEach(engineers::add);
        return engineers;
    }


    @Override
    public Engineer getById(long id) {
        return engineerRepository.findById(id).get();
    }

    @Override
    public void remove(long id) {
        engineerRepository.deleteById(id);
    }

    @Override
    public Engineer insert(Engineer obj) {
        return engineerRepository.save(obj);
    }
}
