package com.enfor.myapp.repository;

import com.enfor.myapp.entity.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RegionsRepository extends CrudRepository<Region, Long> {
    Set<Region> findAll();
}
