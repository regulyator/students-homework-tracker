package com.regulyator.hwtracker.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HomeworkTrackerDiscoveryService {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkTrackerDiscoveryService.class, args);
    }
}
