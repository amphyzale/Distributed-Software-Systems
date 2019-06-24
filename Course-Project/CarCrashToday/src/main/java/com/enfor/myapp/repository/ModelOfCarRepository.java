package com.enfor.myapp.repository;

import com.enfor.myapp.entity.ModelOfCar;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface ModelOfCarRepository extends Repository<ModelOfCar, Long> {
    Set<ModelOfCar> findAll();

    Long findIdByName(String name);

    ModelOfCar findById(Long id);

}
