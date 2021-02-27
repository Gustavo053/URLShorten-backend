package com.logique.demo.controllers;

import com.logique.demo.model.User;
import com.logique.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class UserLogin {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //verifica se o usuário é válido no login
    @PostMapping
    public ResponseEntity<User> authentication(@RequestBody User user) {
        if (userService.findByLogin(user.getLogin()) != null) {
            User userAuth = userService.findByLogin(user.getLogin());
            //Confere as credenciais do usuário
            if (userAuth.getPassword().equals(user.getPassword()) && userAuth.getLogin().equals(user.getLogin())) {
                return ResponseEntity.ok(userAuth);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}
