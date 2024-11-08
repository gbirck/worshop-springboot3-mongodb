package com.coursemongodb.workshopmongo.config;

import com.coursemongodb.workshopmongo.DTO.AuthorDTO;
import com.coursemongodb.workshopmongo.entities.Post;
import com.coursemongodb.workshopmongo.entities.User;
import com.coursemongodb.workshopmongo.repositories.PostRepository;
import com.coursemongodb.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("04/09/2005"), "Viagem de aniversário", "Vou viajar pra Europa hoje! Muitas felicidades.", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("11/11/2018"), "Correção concluida", "Tudo concluido por hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
