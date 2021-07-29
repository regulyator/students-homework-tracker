package com.regulyator.hwtracker.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDto {
    private final String id;
    private final String fio;
    private final String email;

}
