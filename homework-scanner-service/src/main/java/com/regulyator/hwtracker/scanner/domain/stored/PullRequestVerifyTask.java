package com.regulyator.hwtracker.scanner.domain.stored;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("PullRequestVerifyTask")
public class PullRequestVerifyTask {
    @Id
    private final String id;
    @Field("groupId")
    private final String groupId;
    @Field("homeworkId")
    private final String homeworkId;
    @Field("studentId")
    private final String studentId;
    @Field("assignedTeacherId")
    private final String assignedTeacherId;
    @Field("pullRequestUrl")
    private final String pullRequestUrl;
    @Field("verified")
    private final Boolean verified;
}
