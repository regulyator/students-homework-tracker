package com.regulyator.hwtracker.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Group")
public class Group {
    @Id
    private String id;
    @Field("course")
    private Course course;
    @Field("courseStart")
    private LocalDateTime groupStart;
    @Field("courseEnd")
    private LocalDateTime groupEnd;
    @Field("teachers")
    private List<Teacher> teachers;
    @Field("studentGroups")
    private List<StudentGroup> studentGroups;
}
