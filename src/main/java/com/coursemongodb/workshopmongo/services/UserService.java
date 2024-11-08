package com.coursemongodb.workshopmongo.services;

import com.coursemongodb.workshopmongo.DTO.UserDTO;
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

    public User insert(User user) {
        return repo.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User user) {
        User newObj = repo.findById(user.getId()).get();
        updateData(newObj, user);
        return repo.save(newObj);
    }

    public void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
