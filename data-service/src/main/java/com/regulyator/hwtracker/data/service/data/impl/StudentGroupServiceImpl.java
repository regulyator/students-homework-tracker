package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.domain.StudentGroup;
import com.regulyator.hwtracker.data.dto.StudentGroupDto;
import com.regulyator.hwtracker.data.exception.EntityNotFoundException;
import com.regulyator.hwtracker.data.repository.StudentGroupRepository;
import com.regulyator.hwtracker.data.service.data.StudentGroupService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    private final StudentGroupRepository studentGroupRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentGroupServiceImpl(StudentGroupRepository studentGroupRepository,
                                   ModelMapper modelMapper) {
        this.studentGroupRepository = studentGroupRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentGroupDto save(@NonNull StudentGroupDto studentGroupDto) {
        final var savedStudentGroup = studentGroupRepository.save(modelMapper.map(studentGroupDto, StudentGroup.class));
        return modelMapper.map(savedStudentGroup, StudentGroupDto.class);
    }

    @Override
    public StudentGroupDto getById(@NonNull String id) {
        return studentGroupRepository
                .findById(id)
                .map(studentGroup -> modelMapper.map(studentGroup, StudentGroupDto.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<StudentGroupDto> getAll() {
        return studentGroupRepository.findAll().stream()
                .map(studentGroup -> modelMapper.map(studentGroup, StudentGroupDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(@NonNull String id) {
        studentGroupRepository.deleteById(id);
    }
}
