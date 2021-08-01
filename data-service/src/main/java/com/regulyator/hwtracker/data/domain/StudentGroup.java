package com.regulyator.hwtracker.data.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("StudentGroup")
public class StudentGroup {
    @Id
    private final String id;
    @Field("group")
    private final Group group;
    @Field("student")
    private final Student student;
    @Field("githubUserName")
    private final String githubUserName;
    @Field("homeworkRepositoryUrl")
    private final String homeworkRepositoryUrl;
}
