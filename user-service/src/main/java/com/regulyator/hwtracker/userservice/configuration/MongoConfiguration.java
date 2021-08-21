package com.regulyator.hwtracker.userservice.configuration;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongock
@EnableMongoRepositories(basePackages = "com.regulyator.hwtracker.userservice.repository")
public class MongoConfiguration {
}
