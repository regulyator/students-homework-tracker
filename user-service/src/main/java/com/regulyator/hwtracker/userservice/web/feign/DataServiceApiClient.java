package com.regulyator.hwtracker.userservice.web.feign;

import com.regulyator.hwtracker.data.dto.TeacherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("hwtracker-data-core")
public interface DataServiceApiClient {

    @GetMapping("/hwtracker/api/data/teachers/email/{email}")
    TeacherDto getTeacherByEmail(@PathVariable String email);

    @GetMapping("/hwtracker/api/data/teachers/{teacherId}")
    TeacherDto getTeacherById(@PathVariable String teacherId);
}
