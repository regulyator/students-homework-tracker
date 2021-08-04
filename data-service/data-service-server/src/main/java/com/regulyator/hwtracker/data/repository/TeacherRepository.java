package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
