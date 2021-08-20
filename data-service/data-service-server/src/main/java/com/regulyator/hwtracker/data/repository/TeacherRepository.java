package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.Teacher;
import com.regulyator.hwtracker.data.dto.TeacherDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<Teacher, String> {

    Optional<Teacher> findTeacherByEmail(String email);
}
