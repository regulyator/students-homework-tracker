package com.regulyator.hwtracker.data.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("Teacher")
public class Teacher {
    @Id
    private final String id;
    @Field("fio")
    private final String fio;
    @Field("email")
    private final String email;

}
