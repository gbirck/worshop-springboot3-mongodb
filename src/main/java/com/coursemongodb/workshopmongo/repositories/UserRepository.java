package com.coursemongodb.workshopmongo.repositories;

import com.coursemongodb.workshopmongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
