package com.regulyator.hwtracker.data.domain;

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
@Document("StudentGroup")
public class StudentGroup {
    @Id
    private String id;
    @Field("group")
    private Group group;
    @Field("student")
    private Student student;
    @Field("githubUserName")
    private String githubUserName;
    @Field("homeworkRepositoryUrl")
    private String homeworkRepositoryUrl;
}
