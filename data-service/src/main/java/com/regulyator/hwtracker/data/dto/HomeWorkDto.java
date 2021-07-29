package com.regulyator.hwtracker.data.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class HomeWorkDto {
    private final String id;
    private final String homeworkName;
    private final String homeworkDescription;
    private final String homeworkTag;
    private final LocalDateTime homeworkStart;
    private final LocalDateTime homeworkEnd;
    private final GroupDto group;
}
