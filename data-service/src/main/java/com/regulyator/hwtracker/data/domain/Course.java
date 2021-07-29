package com.regulyator.hwtracker.data.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("Course")
public class Course {
    @Id
    private final String id;
    @Field("courseName")
    private final String courseName;
    @Field("courseDescription")
    private final String courseDescription;
}
