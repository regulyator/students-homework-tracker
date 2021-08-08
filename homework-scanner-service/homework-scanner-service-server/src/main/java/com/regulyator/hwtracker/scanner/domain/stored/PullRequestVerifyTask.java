package com.regulyator.hwtracker.scanner.domain.stored;

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
@Document("PullRequestVerifyTask")
public class PullRequestVerifyTask {
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
