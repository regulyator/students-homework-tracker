package com.regulyator.hwtracker.data.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Course")
public class Course {
    @Id
    private String id;
    @Field("courseName")
    private String courseName;
    @Field("courseDescription")
    private String courseDescription;
}
