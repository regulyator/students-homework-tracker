package com.regulyator.hwtracker.scanner.service.feign;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "homework-service", url = "http://127.0.0.1:8130/")
public interface HomeWorkServiceApiClient {

    @GetMapping("/hwtracker/api/homeworks/{homeWorkId}")
    HomeWorkDto getHomeWorkById(@PathVariable String homeWorkId);

    @GetMapping("/hwtracker/api/homeworks")
    List<HomeWorkDto> getAllHomeWorks(@RequestParam(required = false, defaultValue = "false") Boolean active);
}
