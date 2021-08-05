package com.regulyator.hwtracker.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentHomeworkInformationDto {
    private String id;
    private String studentId;
    private String githubUserName;
    private String homeworkRepositoryUrl;
}
