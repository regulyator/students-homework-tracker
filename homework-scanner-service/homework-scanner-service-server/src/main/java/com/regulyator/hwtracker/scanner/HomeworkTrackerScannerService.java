package com.regulyator.hwtracker.scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.regulyator.hwtracker.scanner.web.feign"})
@EnableScheduling
public class HomeworkTrackerScannerService {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkTrackerScannerService.class, args);
    }
}
