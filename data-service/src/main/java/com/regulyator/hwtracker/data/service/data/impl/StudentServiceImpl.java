package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.dto.StudentDto;
import com.regulyator.hwtracker.data.repository.StudentRepository;
import com.regulyator.hwtracker.data.service.data.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto save(StudentDto entity) {
        return null;
    }

    @Override
    public StudentDto getById(String id) {
        return null;
    }

    @Override
    public List<StudentDto> getAll() {
        return null;
    }

    @Override
    public void removeById(String id) {

    }
}
