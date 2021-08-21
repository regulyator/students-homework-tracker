package com.regulyator.hwtracker.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Group")
public class Group {
    @Id
    private String id;
    @Field("groupName")
    private String groupName;
    @Field("course")
    private Course course;
    @Field("courseStart")
    private Date groupStart;
    @Field("courseEnd")
    private Date groupEnd;
    @Field("teachers")
    private List<Teacher> teachers;
    @Field("students")
    private List<Student> students;
}
