package com.logique.demo.controllers;

import com.logique.demo.model.User;
import com.logique.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class UserRegister {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //cadastra o usuário no banco de dados
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        if (userService.findByLogin(user.getLogin()) != null) {
            return ResponseEntity.notFound().build();
        } else {
            userService.createAndUpdate(user);
            return ResponseEntity.ok(user);
        }
    }
}
