package com.gabrielsantana.workshopmongo.services;

import com.gabrielsantana.workshopmongo.domain.User;
import com.gabrielsantana.workshopmongo.dto.UserDTO;
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

    public User insert(User obj){
        return repo.save(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void saveUser(User user){
        repo.save(user);
    }

}
