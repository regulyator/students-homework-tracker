package com.regulyator.hwtracker.scanner.service.external.homework;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;

import java.util.List;

public interface HomeWorkApiExchangeService {
    HomeWorkDto getHomeWorkById(String homeWorkId);

    List<HomeWorkDto> getAllHomeWorks(boolean onlyActive);
}
