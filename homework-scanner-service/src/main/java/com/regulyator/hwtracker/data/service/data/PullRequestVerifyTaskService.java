package com.regulyator.hwtracker.data.service.data;

import com.regulyator.hwtracker.data.domain.PullRequestVerifyTask;
import com.regulyator.hwtracker.data.dto.PullRequestVerifyTaskDto;

import java.util.List;

public interface PullRequestVerifyTaskService {

    PullRequestVerifyTaskDto save(PullRequestVerifyTaskDto pullRequestVerifyTaskDto);

    PullRequestVerifyTaskDto getById(String id);

    List<PullRequestVerifyTaskDto> getAll();

    void removeById(String id);

    List<PullRequestVerifyTaskDto> getAllByAssignedTeacherId(String teacherId);

    List<PullRequestVerifyTaskDto> getAllByAssignedTeacherIdIsNull();

    List<PullRequestVerifyTaskDto> getAllByStudentId(String studentId);

    List<PullRequestVerifyTaskDto> getAllByGroupId(String groupId);

    List<PullRequestVerifyTaskDto> getAllByHomeworkId(String homeworkId);

    List<PullRequestVerifyTaskDto> getAllByVerified(Boolean verified);
}
