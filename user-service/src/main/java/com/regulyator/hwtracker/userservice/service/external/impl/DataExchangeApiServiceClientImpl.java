package com.regulyator.hwtracker.userservice.service.external.impl;

import com.regulyator.hwtracker.data.dto.TeacherDto;
import com.regulyator.hwtracker.userservice.service.external.DataExchangeApiServiceClient;
import com.regulyator.hwtracker.userservice.web.feign.DataServiceApiClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataExchangeApiServiceClientImpl implements DataExchangeApiServiceClient {
    private final DataServiceApiClient dataServiceApiClient;

    @Autowired
    public DataExchangeApiServiceClientImpl(DataServiceApiClient dataServiceApiClient) {
        this.dataServiceApiClient = dataServiceApiClient;
    }

    @Override
    public TeacherDto getTeacherByEmail(String teacherEmail) {
        try {
            return dataServiceApiClient.getTeacherByEmail(teacherEmail);
        } catch (FeignException feignException) {
            return null;
        }
    }

    @Override
    public TeacherDto getTeacherById(String teacherId) {
        try {
            return dataServiceApiClient.getTeacherById(teacherId);
        } catch (FeignException feignException) {
            return null;
        }
    }
}
