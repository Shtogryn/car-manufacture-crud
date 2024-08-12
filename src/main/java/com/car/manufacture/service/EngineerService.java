package com.car.manufacture.service;

import com.car.manufacture.entities.Engineer;
import java.util.LinkedHashSet;

public interface EngineerService<T>{
    public LinkedHashSet<Engineer> getAllEngineers();
    T getById(long id);
    void remove(long id);
    T insert(T obj);
}