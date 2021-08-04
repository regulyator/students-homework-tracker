package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
