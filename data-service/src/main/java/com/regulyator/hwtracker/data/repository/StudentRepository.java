package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
