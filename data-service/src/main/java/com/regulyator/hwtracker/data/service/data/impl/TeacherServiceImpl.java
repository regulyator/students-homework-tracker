package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.dto.TeacherDto;
import com.regulyator.hwtracker.data.repository.TeacherRepository;
import com.regulyator.hwtracker.data.service.data.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository,
                              ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
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
        teacherRepository.deleteById(id);
    }
}
