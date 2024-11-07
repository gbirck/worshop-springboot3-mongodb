package com.coursemongodb.workshopmongo.services;

import com.coursemongodb.workshopmongo.entities.User;
import com.coursemongodb.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.coursemongodb.workshopmongo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findById(id).get();
        if (user == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado!");
        }
        else {
            return user;
        }
    }
}
