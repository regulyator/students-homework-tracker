package com.regulyator.hwtracker.data.service.data;

import com.regulyator.hwtracker.data.dto.TeacherDto;

import java.util.Optional;

public interface TeacherService extends StandardDataService<TeacherDto> {

    TeacherDto getTeacherByEmail(String email);
}
