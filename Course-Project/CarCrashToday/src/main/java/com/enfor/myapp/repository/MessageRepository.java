package com.enfor.myapp.repository;

import com.enfor.myapp.entity.Message;
import com.enfor.myapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Page<Message> findByTag(String tag, Pageable pageable);

    Page<Message> findAll(Pageable pageable);

    Page<Message> findByAuthor(User user, Pageable pageable);

}
