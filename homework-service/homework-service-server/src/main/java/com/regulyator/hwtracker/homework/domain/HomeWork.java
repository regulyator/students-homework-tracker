package com.regulyator.hwtracker.homework.domain;

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
@Document("HomeWork")
public class HomeWork {
    @Id
    private String id;
    @Field("homeworkName")
    private String homeworkName;
    @Field("homeworkDescription")
    private String homeworkDescription;
    @Field("homeworkTag")
    private String homeworkTag;
    @Field("homeworkStart")
    private LocalDateTime homeworkStart;
    @Field("homeworkEnd")
    private LocalDateTime homeworkEnd;
    @Field("groupId")
    private String groupId;
    @Field("students")
    private List<StudentHomeworkInformation> students;
}
