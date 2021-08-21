package com.regulyator.hwtracker.homework.web.feign;

import com.regulyator.hwtracker.data.dto.GroupDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("hwtracker-data-core")
public interface DataServiceApiClient {

    @GetMapping("/hwtracker/api/data/groups/{groupId}")
    GroupDto getGroupDtoById(@PathVariable String groupId);
}
