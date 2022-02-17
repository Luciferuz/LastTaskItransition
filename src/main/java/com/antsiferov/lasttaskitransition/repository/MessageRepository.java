package com.antsiferov.lasttaskitransition.repository;

import com.antsiferov.lasttaskitransition.entity.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageRepository extends CrudRepository<Message, Integer> {

    Iterable<Message> findAllByRecipient(String recipient);
}