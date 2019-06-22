package com.enfor.myapp.repository;

import com.enfor.myapp.entity.City;
import com.enfor.myapp.entity.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.Set;
import java.util.concurrent.Future;

public interface CitiesRepository extends CrudRepository<City, Long> {
    @Async
    Future<Set<City>> findAllByRegion(Region region);

    Set<City> findAll();
}
