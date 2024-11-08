package com.coursemongodb.workshopmongo.services;

import com.coursemongodb.workshopmongo.DTO.UserDTO;
import com.coursemongodb.workshopmongo.entities.Post;
import com.coursemongodb.workshopmongo.entities.User;
import com.coursemongodb.workshopmongo.repositories.PostRepository;
import com.coursemongodb.workshopmongo.repositories.UserRepository;
import com.coursemongodb.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Post post = repo.findById(id).get();
        if (post == null) {
            throw new ObjectNotFoundException("Objeto nao encontrado!");
        } else {
            return post;
        }
    }

}
