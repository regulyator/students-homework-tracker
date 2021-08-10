package com.regulyator.hwtracker.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.regulyator.hwtracker.data.web.feign"})
public class HomeworkTrackerDataService {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkTrackerDataService.class, args);
    }
}
