package com.logique.demo.controllers;

import com.logique.demo.model.Url;
import com.logique.demo.model.User;
import com.logique.demo.service.UrlService;
import com.logique.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class Link {
    private UserService userService;
    private UrlService urlService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUrlService(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping(path = "/get/{userId}")
    public ResponseEntity<User> findAll(@PathVariable String userId) {
        if (userService.getById(userId) != null) {
            return ResponseEntity.ok(userService.getById(userId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<List<Url>> getById(@PathVariable String userId) {
        if (userService.getById(userId) != null) {
            return ResponseEntity.ok(urlService .findAllByUserId(userId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
