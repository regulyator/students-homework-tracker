package com.regulyator.hwtracker.data.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class GroupDto {
    private final String id;
    private final CourseDto course;
    private final LocalDateTime groupStart;
    private final LocalDateTime groupEnd;
    private final List<TeacherDto> teachers;
    private final List<StudentGroupDto> studentGroups;
}
