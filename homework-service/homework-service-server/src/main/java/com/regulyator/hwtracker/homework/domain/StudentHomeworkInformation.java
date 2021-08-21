package com.regulyator.hwtracker.homework.domain;

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
@Document("StudentHomeworkInformation")
public class StudentHomeworkInformation {
    @Id
    private String id;
    @Field("studentId")
    private String studentId;
    @Field("githubUserName")
    private String githubUserName;
    @Field("homeworkRepositoryUrl")
    private String homeworkRepositoryUrl;

}
