package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.HomeWork;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HomeWorkRepository extends MongoRepository<HomeWork, String> {

    List<HomeWork> findAllByGroup_IdAndHomeworkStartBeforeAndHomeworkEndAfter(String groupId, LocalDateTime start, LocalDateTime end);

    List<HomeWork> findAllByGroup_IdInAndHomeworkStartBeforeAndHomeworkEndAfter(List<String> groupsIds, LocalDateTime start, LocalDateTime end);

}
