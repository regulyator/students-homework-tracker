package com.regulyator.hwtracker.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentGroupDto {
    private final String id;
    private final GroupDto group;
    private final StudentDto student;
    private final String homeworkRepositoryUrl;
}
