package com.logique.demo.repository;

import com.logique.demo.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UrlRepository extends MongoRepository<Url, String> {
    List<Url> getAllById(String id);
    List<Url> findAllByUserId(String id);
}