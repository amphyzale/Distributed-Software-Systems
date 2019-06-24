package com.enfor.myapp.repository;

import com.enfor.myapp.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CarRepository extends CrudRepository<Car, Long> {
    Set<Car> findAll();

}
