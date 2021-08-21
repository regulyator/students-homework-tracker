package com.regulyator.hwtracker.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.regulyator.hwtracker.userservice.web.feign"})
public class HomeworkTrackerUserService {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkTrackerUserService.class, args);
    }
}
