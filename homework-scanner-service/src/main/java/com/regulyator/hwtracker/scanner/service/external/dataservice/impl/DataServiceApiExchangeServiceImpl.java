package com.regulyator.hwtracker.scanner.service.external.dataservice.impl;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.data.dto.StudentGroupDto;
import com.regulyator.hwtracker.scanner.service.external.dataservice.DataServiceApiExchangeService;
import com.regulyator.hwtracker.scanner.service.feign.DataServiceApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceApiExchangeServiceImpl implements DataServiceApiExchangeService {
    private final DataServiceApiClient dataServiceApiClient;

    @Autowired
    public DataServiceApiExchangeServiceImpl(DataServiceApiClient dataServiceApiClient) {
        this.dataServiceApiClient = dataServiceApiClient;
    }

    @Override
    public List<StudentGroupDto> getActiveStudentGroups() {
        return dataServiceApiClient.getActiveStudentGroups();
    }

    @Override
    public List<HomeWorkDto> getAllActiveHomeWorksByGroupId(String groupId) {
        return dataServiceApiClient.getAllActiveHomeWorksByGroupId(groupId);
    }
}
