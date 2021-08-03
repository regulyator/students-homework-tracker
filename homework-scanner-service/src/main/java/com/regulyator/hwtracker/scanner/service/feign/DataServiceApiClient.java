package com.regulyator.hwtracker.scanner.service.feign;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.data.dto.StudentGroupDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "data-service", url = "http://127.0.0.1:8110/")
public interface DataServiceApiClient {

    @GetMapping("hwtracker/api/data/studentgroups/active")
    List<StudentGroupDto> getActiveStudentGroups();

    @GetMapping("/hwtracker/api/data/homeworks/active/{groupId}")
    List<HomeWorkDto> getAllActiveHomeWorksByGroupId(@PathVariable String groupId);
}
