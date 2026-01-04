package com.gabrielsantana.workshopmongo.resources;

import com.gabrielsantana.workshopmongo.domain.User;
import com.gabrielsantana.workshopmongo.repository.UserRepository;
import com.gabrielsantana.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repo;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/test")
    public User testInsert() {
        return repo.save(new User("teste", "teste", null));
    }
}

