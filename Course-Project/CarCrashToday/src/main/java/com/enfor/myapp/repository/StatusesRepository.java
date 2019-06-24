package com.enfor.myapp.repository;

import com.enfor.myapp.entity.Status;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface StatusesRepository extends Repository<Status, Long> {
    Set<Status> findAll();

    Status findById(Long id);
}
