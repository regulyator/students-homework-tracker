package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.domain.PullRequestVerifyTask;
import com.regulyator.hwtracker.data.dto.PullRequestVerifyTaskDto;
import com.regulyator.hwtracker.data.repository.PullRequestVerifyTaskRepository;
import com.regulyator.hwtracker.data.service.data.PullRequestVerifyTaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PullRequestVerifyTaskServiceImpl implements PullRequestVerifyTaskService {
    private final PullRequestVerifyTaskRepository pullRequestVerifyTaskRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PullRequestVerifyTaskServiceImpl(PullRequestVerifyTaskRepository pullRequestVerifyTaskRepository,
                                            ModelMapper modelMapper) {
        this.pullRequestVerifyTaskRepository = pullRequestVerifyTaskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PullRequestVerifyTaskDto save(PullRequestVerifyTaskDto pullRequestVerifyTaskDto) {
        final var savedPullRequestVerifyTask = pullRequestVerifyTaskRepository
                .save(modelMapper.map(pullRequestVerifyTaskDto, PullRequestVerifyTask.class));
        return modelMapper.map(savedPullRequestVerifyTask, PullRequestVerifyTaskDto.class);
    }

    @Override
    public PullRequestVerifyTaskDto getById(String id) {
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAll() {
        return null;
    }

    @Override
    public void removeById(String id) {

    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByAssignedTeacherId(String teacherId) {
        return null;
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByAssignedTeacherIdIsNull() {
        return null;
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByStudentId(String studentId) {
        return null;
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByGroupId(String groupId) {
        return null;
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByHomeworkId(String homeworkId) {
        return null;
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByVerified(Boolean verified) {
        return null;
    }
}
