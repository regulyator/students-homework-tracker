package com.regulyator.hwtracker.data.service.data;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;

import java.util.List;

public interface HomeworkService extends StandardDataService<HomeWorkDto> {

    List<HomeWorkDto> getActiveHomeWorkByGroupId(String groupId);
}
