package com.enfor.myapp.repository;

import com.enfor.myapp.entity.TypeOfRoadObj;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoadObjectsRepository extends CrudRepository<TypeOfRoadObj, Long> {
    Set<TypeOfRoadObj> findAll();
}
