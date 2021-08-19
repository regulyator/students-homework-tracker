package com.regulyator.hwtracker.userservice.repository;

import com.regulyator.hwtracker.userservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

    Optional<User> findByTeacherId(String teacherId);
}
