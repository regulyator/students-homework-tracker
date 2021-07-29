package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.StudentGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentGroupRepository extends MongoRepository<StudentGroup, String> {
}
