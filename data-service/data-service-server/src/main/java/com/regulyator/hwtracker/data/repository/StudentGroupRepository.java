package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.StudentGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentGroupRepository extends MongoRepository<StudentGroup, String> {

    List<StudentGroup> findAllByGroup_GroupStartBeforeAndGroup_GroupEndAfter(LocalDateTime start, LocalDateTime end);
}
