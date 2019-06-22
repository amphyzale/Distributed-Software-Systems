package com.enfor.myapp.repository;

import com.enfor.myapp.entity.City;
import com.enfor.myapp.entity.Street;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.Set;
import java.util.concurrent.Future;

public interface StreetsRepository extends CrudRepository<Street, Long> {
    @Async
    Future<Set<Street>> findAllByCity(City city);

    Set<Street> findAll();
}
