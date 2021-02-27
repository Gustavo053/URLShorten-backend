package com.logique.demo.repository;

import com.logique.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByLogin(String login);
    User getById(String id);
    void deleteByLogin(String login);
}