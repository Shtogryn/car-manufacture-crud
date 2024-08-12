package com.car.manufacture.repository;

import com.car.manufacture.entities.Engineer;
import org.springframework.data.repository.CrudRepository;

public interface EngineerRepository extends CrudRepository<Engineer, Long> {
}