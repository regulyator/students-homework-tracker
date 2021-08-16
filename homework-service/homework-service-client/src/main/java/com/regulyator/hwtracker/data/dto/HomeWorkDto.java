package com.regulyator.hwtracker.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeWorkDto {
    private String id;
    private String homeworkName;
    private String homeworkDescription;
    private String homeworkTag;
    private Date homeworkStart;
    private Date homeworkEnd;
    private String groupId;
    private List<StudentHomeworkInformationDto> students;
}
