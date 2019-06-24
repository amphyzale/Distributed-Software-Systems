package com.enfor.myapp.repository;

import com.enfor.myapp.entity.TypeOfBody;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface TypeOfBodyRepository extends Repository<TypeOfBody, Long> {
    Set<TypeOfBody> findAll();

    TypeOfBody findById(Long id);

    Long findIdByName(String name);
}
