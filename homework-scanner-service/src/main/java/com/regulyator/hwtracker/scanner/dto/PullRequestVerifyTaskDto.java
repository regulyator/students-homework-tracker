package com.regulyator.hwtracker.scanner.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
public class PullRequestVerifyTaskDto {
    private final String id;
    private final String groupId;
    private final String homeworkId;
    private final String studentId;
    private final String assignedTeacherId;
    private final String pullRequestUrl;
    private final Boolean verified;
}
