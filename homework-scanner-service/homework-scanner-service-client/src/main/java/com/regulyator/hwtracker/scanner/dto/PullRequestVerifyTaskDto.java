package com.regulyator.hwtracker.scanner.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PullRequestVerifyTaskDto {
    private String id;
    private String groupId;
    private String homeworkId;
    private String studentId;
    private String assignedTeacherId;
    private String pullRequestUrl;
    private Boolean verified;
}
