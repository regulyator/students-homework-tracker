package com.regulyator.hwtracker.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroupDto {
    private String id;
    private GroupDto group;
    private StudentDto student;
    private String githubUserName;
    private String homeworkRepositoryUrl;

}
