package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.HomeWork;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HomeWorkRepository extends MongoRepository<HomeWork, String> {
}
