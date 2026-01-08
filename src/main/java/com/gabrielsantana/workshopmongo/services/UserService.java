package com.gabrielsantana.workshopmongo.services;

import com.gabrielsantana.workshopmongo.domain.User;
import com.gabrielsantana.workshopmongo.repository.UserRepository;
import com.gabrielsantana.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found"));
    }

    public void saveUser(User user){
        repo.save(user);
    }

}
