package com.regulyator.hwtracker.scanner.service.data.impl;

import com.regulyator.hwtracker.scanner.domain.stored.PullRequestVerifyTask;
import com.regulyator.hwtracker.scanner.dto.PullRequestVerifyTaskDto;
import com.regulyator.hwtracker.scanner.exception.EntityNotFoundException;
import com.regulyator.hwtracker.scanner.repository.PullRequestVerifyTaskRepository;
import com.regulyator.hwtracker.scanner.service.data.PullRequestVerifyTaskService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public PullRequestVerifyTaskDto save(@NonNull PullRequestVerifyTaskDto pullRequestVerifyTaskDto) {
        final var savedPullRequestVerifyTask = pullRequestVerifyTaskRepository
                .save(modelMapper.map(pullRequestVerifyTaskDto, PullRequestVerifyTask.class));
        return modelMapper.map(savedPullRequestVerifyTask, PullRequestVerifyTaskDto.class);
    }

    @Override
    public PullRequestVerifyTaskDto assignTeacherForTask(@NonNull String teacherId, @NonNull String taskId) {
        final var task = pullRequestVerifyTaskRepository.findById(taskId)
                .orElseThrow(EntityNotFoundException::new);
        task.setAssignedTeacherId(teacherId);
        return modelMapper.map(pullRequestVerifyTaskRepository.save(task), PullRequestVerifyTaskDto.class);
    }

    @Override
    public PullRequestVerifyTaskDto getById(@NonNull String id) {
        return pullRequestVerifyTaskRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAll() {
        return pullRequestVerifyTaskRepository.findAll()
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<PullRequestVerifyTaskDto> getAllByAssignedTeacherId(@NonNull String teacherId) {
        return pullRequestVerifyTaskRepository.findAllByAssignedTeacherId(teacherId)
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByAssignedTeacherIdIsNull() {
        return pullRequestVerifyTaskRepository.findAllByAssignedTeacherIdIsNull()
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByStudentId(@NonNull String studentId) {
        return pullRequestVerifyTaskRepository.findAllByStudentId(studentId)
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByGroupId(@NonNull String groupId) {
        return pullRequestVerifyTaskRepository.findAllByGroupId(groupId)
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByHomeworkId(@NonNull String homeworkId) {
        return pullRequestVerifyTaskRepository.findAllByHomeworkId(homeworkId)
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PullRequestVerifyTaskDto> getAllByVerified(@NonNull Boolean verified) {
        return pullRequestVerifyTaskRepository.findAllByVerified(verified)
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(String id) {
        pullRequestVerifyTaskRepository.deleteById(id);
    }

    private PullRequestVerifyTaskDto convertToDto(PullRequestVerifyTask pullRequestVerifyTask) {
        return modelMapper.map(pullRequestVerifyTask, PullRequestVerifyTaskDto.class);
    }
}
