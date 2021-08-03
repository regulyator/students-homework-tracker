package com.regulyator.hwtracker.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private String id;
    private CourseDto course;
    private LocalDateTime groupStart;
    private LocalDateTime groupEnd;
    private List<TeacherDto> teachers;
    private List<StudentGroupDto> studentGroups;
}
