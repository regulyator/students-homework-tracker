package com.regulyator.hwtracker.data.repository;

import com.regulyator.hwtracker.data.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
