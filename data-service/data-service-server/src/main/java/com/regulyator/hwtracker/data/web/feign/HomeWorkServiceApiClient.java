package com.regulyator.hwtracker.data.web.feign;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("hwtracker-data-homework")
public interface HomeWorkServiceApiClient {

    @GetMapping("/hwtracker/api/homeworks/{homeWorkId}")
    HomeWorkDto getHomeWorkById(@PathVariable String homeWorkId);

    @GetMapping("/hwtracker/api/homeworks")
    List<HomeWorkDto> getAllHomeWorks(@RequestParam(required = false, defaultValue = "false") Boolean active);
}
