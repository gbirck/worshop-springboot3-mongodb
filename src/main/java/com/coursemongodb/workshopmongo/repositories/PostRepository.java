package com.coursemongodb.workshopmongo.repositories;

import com.coursemongodb.workshopmongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
