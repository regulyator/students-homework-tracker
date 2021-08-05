package com.regulyator.hwtracker.homework.configuration.db;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.regulyator.hwtracker.homework.repository")
public class MongoConfiguration {
}
