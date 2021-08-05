package com.regulyator.hwtracker.homework.repository;

import com.regulyator.hwtracker.homework.domain.HomeWork;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HomeWorkRepository extends MongoRepository<HomeWork, String> {

    List<HomeWork> findAllByHomeworkStartBeforeAndHomeworkEndAfter(LocalDateTime start, LocalDateTime end);
}
