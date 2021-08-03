package com.regulyator.hwtracker.data.service.data;

import com.regulyator.hwtracker.data.dto.StudentGroupDto;

import java.util.List;

public interface StudentGroupService extends StandardDataService<StudentGroupDto> {

    List<StudentGroupDto> getActiveStudentGroup();
}
