package com.regulyator.hwtracker.homework.service.external.impl;

import com.regulyator.hwtracker.data.dto.GroupDto;
import com.regulyator.hwtracker.homework.service.external.DataExchangeApiServiceClient;
import com.regulyator.hwtracker.homework.web.feign.DataServiceApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataExchangeApiServiceClientImpl implements DataExchangeApiServiceClient {
    private final DataServiceApiClient dataServiceApiClient;

    @Autowired
    public DataExchangeApiServiceClientImpl(DataServiceApiClient dataServiceApiClient) {
        this.dataServiceApiClient = dataServiceApiClient;
    }

    @Override
    public Optional<GroupDto> getGroupDtoById(String groupId) {
        return Optional.ofNullable(dataServiceApiClient.getGroupDtoById(groupId));
    }
}
