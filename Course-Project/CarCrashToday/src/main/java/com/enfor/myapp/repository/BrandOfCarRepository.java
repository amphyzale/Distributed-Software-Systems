package com.enfor.myapp.repository;

import com.enfor.myapp.entity.BrandOfCar;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface BrandOfCarRepository extends Repository<BrandOfCar, Long> {
    Set<BrandOfCar> findAll();

    BrandOfCar findById(Long id);
}
