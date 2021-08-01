package com.regulyator.hwtracker.scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.regulyator.hwtracker.scanner.service.feign"})
public class HomeworkTrackerScannerService {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkTrackerScannerService.class, args);
    }
}
