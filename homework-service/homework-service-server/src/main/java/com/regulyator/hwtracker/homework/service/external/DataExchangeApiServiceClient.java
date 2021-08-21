package com.regulyator.hwtracker.homework.service.external;

import com.regulyator.hwtracker.data.dto.GroupDto;

import java.util.Optional;

public interface DataExchangeApiServiceClient {

    Optional<GroupDto> getGroupDtoById(String groupId);
}
