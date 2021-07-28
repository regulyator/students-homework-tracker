package com.regulyator.hwtracker.data.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document("Group")
public class Group {
    @Id
    private final String id;
    @Field("course")
    private final Course course;
    @Field("courseStart")
    private final LocalDateTime groupStart;
    @Field("courseEnd")
    private final LocalDateTime groupEnd;
    @Field("teachers")
    private final List<Teacher> teachers;
    @Field("students")
    private final List<Student> students;
}
