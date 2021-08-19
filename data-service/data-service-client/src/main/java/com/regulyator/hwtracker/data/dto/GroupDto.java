package com.regulyator.hwtracker.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private String id;
    private String groupName;
    private CourseDto course;
    private Date groupStart;
    private Date groupEnd;
    private List<TeacherDto> teachers;
    private List<StudentDto> students;
}
