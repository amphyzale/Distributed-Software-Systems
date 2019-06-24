package com.enfor.myapp.repository;

import com.enfor.myapp.entity.TypeOfTransport;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface TypeOfTransportRepository extends Repository<TypeOfTransport, Long> {
    Set<TypeOfTransport> findAll();

    TypeOfTransport findById(Long id);

    Long findIdByName(String name);
}
