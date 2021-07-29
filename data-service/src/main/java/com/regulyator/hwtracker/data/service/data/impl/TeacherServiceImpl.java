package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.dto.TeacherDto;
import com.regulyator.hwtracker.data.repository.TeacherRepository;
import com.regulyator.hwtracker.data.service.data.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDto save(TeacherDto entity) {
        return null;
    }

    @Override
    public TeacherDto getById(String id) {
        return null;
    }

    @Override
    public List<TeacherDto> getAll() {
        return null;
    }

    @Override
    public void removeById(String id) {

    }
}
