package com.logique.demo.service;

import com.logique.demo.model.Url;
import com.logique.demo.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlService {
    private UrlRepository urlRepository;

    @Autowired
    public void setUrlRepository(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public List<Url> findAll() {
        return urlRepository.findAll();
    }

    public Optional<Url> findById(String id) {
        return urlRepository.findById(id);
    }

    public Url createAndUpdate(Url url) {
        return urlRepository.save(url);
    }
}