package com.regulyator.hwtracker.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.regulyator.hwtracker.homework.web.feign"})
public class HomeworkTrackerHomeworkService {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkTrackerHomeworkService.class, args);
    }
}
