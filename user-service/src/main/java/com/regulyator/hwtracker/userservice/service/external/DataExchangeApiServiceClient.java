package com.regulyator.hwtracker.userservice.service.external;

import com.regulyator.hwtracker.data.dto.TeacherDto;

public interface DataExchangeApiServiceClient {

    TeacherDto getTeacherByEmail(String teacherEmail);

    TeacherDto getTeacherById(String teacherId);
}
