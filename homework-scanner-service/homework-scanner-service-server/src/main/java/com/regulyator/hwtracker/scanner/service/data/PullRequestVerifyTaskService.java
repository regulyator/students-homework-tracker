package com.regulyator.hwtracker.scanner.service.data;

import com.regulyator.hwtracker.scanner.dto.PullRequestVerifyTaskDto;

import java.util.List;

public interface PullRequestVerifyTaskService {

    PullRequestVerifyTaskDto save(PullRequestVerifyTaskDto pullRequestVerifyTaskDto);

    PullRequestVerifyTaskDto assignTeacherForTask(String teacherId, String taskId);

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
