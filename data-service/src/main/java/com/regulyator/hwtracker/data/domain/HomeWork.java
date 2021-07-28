package com.regulyator.hwtracker.data.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Builder
@Document("HomeWork")
public class HomeWork {
    @Id
    private final String id;
    @Field("homeworkName")
    private final String homeworkName;
    @Field("homeworkDescription")
    private final String homeworkDescription;
    @Field("homeworkTag")
    private final String homeworkTag;
    @Field("homeworkStart")
    private final LocalDateTime homeworkStart;
    @Field("homeworkEnd")
    private final LocalDateTime homeworkEnd;
    @Field("group")
    private final Group group;
}
