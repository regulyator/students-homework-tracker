package com.regulyator.hwtracker.scanner.repository;

import com.regulyator.hwtracker.scanner.domain.stored.PullRequestVerifyTask;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PullRequestVerifyTaskRepository extends MongoRepository<PullRequestVerifyTask, String> {

    List<PullRequestVerifyTask> findAllByAssignedTeacherId(String teacherId);

    List<PullRequestVerifyTask> findAllByAssignedTeacherIdIsNull();

    List<PullRequestVerifyTask> findAllByStudentId(String studentId);

    List<PullRequestVerifyTask> findAllByGroupId(String groupId);

    List<PullRequestVerifyTask> findAllByHomeworkId(String homeworkId);

    List<PullRequestVerifyTask> findAllByVerified(Boolean verified);

    boolean existsByPullRequestUrl(String pullRequestUrl);
}
