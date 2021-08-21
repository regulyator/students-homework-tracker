package com.regulyator.hwtracker.data.service.external.homework.impl;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.data.service.external.homework.HomeWorkApiExchangeService;
import com.regulyator.hwtracker.data.web.feign.HomeWorkServiceApiClient;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeWorkApiExchangeServiceImpl implements HomeWorkApiExchangeService {
    private final HomeWorkServiceApiClient homeWorkServiceApiClient;

    @Autowired
    public HomeWorkApiExchangeServiceImpl(HomeWorkServiceApiClient homeWorkServiceApiClient) {
        this.homeWorkServiceApiClient = homeWorkServiceApiClient;
    }

    @Override
    public HomeWorkDto getHomeWorkById(@NonNull String homeWorkId) {
        return homeWorkServiceApiClient.getHomeWorkById(homeWorkId);
    }

    @Override
    public List<HomeWorkDto> getAllHomeWorks(@NonNull boolean onlyActive) {
        return homeWorkServiceApiClient.getAllHomeWorks(onlyActive);
    }
}
