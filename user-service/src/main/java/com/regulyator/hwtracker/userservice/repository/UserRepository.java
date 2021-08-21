package com.regulyator.hwtracker.userservice.repository;

import com.regulyator.hwtracker.userservice.domain.stored.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsUserByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<User> findByTeacherId(String teacherId);
}
