package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.dto.StudentGroupDto;
import com.regulyator.hwtracker.data.repository.StudentGroupRepository;
import com.regulyator.hwtracker.data.service.data.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    private final StudentGroupRepository studentGroupRepository;

    @Autowired
    public StudentGroupServiceImpl(StudentGroupRepository studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }

    @Override
    public StudentGroupDto save(StudentGroupDto entity) {
        return null;
    }

    @Override
    public StudentGroupDto getById(String id) {
        return null;
    }

    @Override
    public List<StudentGroupDto> getAll() {
        return null;
    }

    @Override
    public void removeById(String id) {

    }
}
