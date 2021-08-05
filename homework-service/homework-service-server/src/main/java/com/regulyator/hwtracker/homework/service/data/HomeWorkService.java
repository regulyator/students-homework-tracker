package com.regulyator.hwtracker.homework.service.data;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.homework.domain.HomeWork;

import java.time.LocalDateTime;
import java.util.List;

public interface HomeWorkService extends StandardDataService<HomeWorkDto> {

    List<HomeWorkDto> getAllActiveHomeworks();

    List<HomeWorkDto> getAllHomeWorkByPeriod(LocalDateTime start, LocalDateTime end);
}
