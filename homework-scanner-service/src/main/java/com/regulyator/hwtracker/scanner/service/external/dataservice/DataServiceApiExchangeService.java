package com.regulyator.hwtracker.scanner.service.external.dataservice;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.data.dto.StudentGroupDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DataServiceApiExchangeService {

    List<StudentGroupDto> getActiveStudentGroups();

    List<HomeWorkDto> getAllActiveHomeWorksByGroupId(String groupId);
}
