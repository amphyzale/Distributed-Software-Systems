package com.enfor.myapp.repository;

import com.enfor.myapp.entity.Message;
import com.enfor.myapp.entity.Status;
import com.enfor.myapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Page<Message> findByTag(String tag, Pageable pageable);

    Page<Message> findByTagAndStatus(String tag, Pageable pageable, Status status);

    Page<Message> findAll(Pageable pageable);

    Page<Message> findAllByStatus(Pageable pageable, Status status);

    Set<Message> findAllByStatus(Status status);

    Page<Message> findByAuthor(User user, Pageable pageable);

    Page<Message> findByAuthorAndStatus(User user, Pageable pageable, Status status);

}
