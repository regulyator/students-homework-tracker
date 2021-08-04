package com.regulyator.hwtracker.scanner.configuration.db;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.regulyator.hwtracker.data.repository")
public class MongoConfiguration {
}
