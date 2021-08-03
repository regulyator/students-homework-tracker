package com.regulyator.hwtracker.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeWorkDto {
    private String id;
    private String homeworkName;
    private String homeworkDescription;
    private String homeworkTag;
    private LocalDateTime homeworkStart;
    private LocalDateTime homeworkEnd;
    private GroupDto group;
}
