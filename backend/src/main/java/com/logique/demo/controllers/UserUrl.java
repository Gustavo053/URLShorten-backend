package com.logique.demo.controllers;

import com.logique.demo.model.Url;
import com.logique.demo.model.User;
import com.logique.demo.service.UrlService;
import com.logique.demo.service.UserService;
import com.logique.demo.utils.Shortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class UserUrl {
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

    @PostMapping
    public ResponseEntity<Url> create(@RequestBody Url url) {
        //verifica se o usuário é válido no banco de dados
        if (userService.getById(url.getUserId()) != null) {
            User user = userService.getById(url.getUserId());
            List<Url> urls;

            //se o usuário não tiver links, é criado uma nova lista para seus links
            if (user.getUrls() == null) {
                urls = new ArrayList<>();
            } else {
                urls = user.getUrls();
            }

            urls.add(url);
            user.setUrls(urls);

            urlService.createAndUpdate(url);
            userService.createAndUpdate(user);

            return ResponseEntity.ok(url);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}