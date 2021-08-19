package com.regulyator.hwtracker.scanner.service.data;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.scanner.domain.github.PullRequest;
import com.regulyator.hwtracker.scanner.dto.PullRequestVerifyTaskDto;

import java.util.List;

public interface PullRequestVerifyTaskService {

    List<PullRequestVerifyTaskDto> getAllByAssignedTeacherId(String teacherId);

    List<PullRequestVerifyTaskDto> getAllByAssignedTeacherIdIsNull();

    List<PullRequestVerifyTaskDto> getAllByStudentId(String studentId);

    List<PullRequestVerifyTaskDto> getAllByGroupId(String groupId);

    List<PullRequestVerifyTaskDto> getAllByHomeworkId(String homeworkId);

    List<PullRequestVerifyTaskDto> getAllByVerified(Boolean verified);

    PullRequestVerifyTaskDto save(PullRequestVerifyTaskDto pullRequestVerifyTaskDto);

    PullRequestVerifyTaskDto save(PullRequest pullRequest, HomeWorkDto homeWork, String studentId);

    PullRequestVerifyTaskDto getById(String id);

    List<PullRequestVerifyTaskDto> getAll();

    void removeById(String id);

    boolean existsByPullRequestUrl(String pullRequestUrl);
}
