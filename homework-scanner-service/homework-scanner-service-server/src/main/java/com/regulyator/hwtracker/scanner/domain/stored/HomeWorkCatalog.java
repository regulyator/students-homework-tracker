package com.regulyator.hwtracker.scanner.domain.stored;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("HomeWorkCatalog")
public class HomeWorkCatalog {
    @Id
    private String id;
    @Field("groupId")
    private String groupId;
    @Field("homeworkId")
    private String homeworkId;
    @Field("studentId")
    private String studentId;
    @Field("assignedTeacherId")
    private String assignedTeacherId;
    @Field("pullRequestUrl")
    private String pullRequestUrl;
    @Field("verified")
    private Boolean verified;
}
