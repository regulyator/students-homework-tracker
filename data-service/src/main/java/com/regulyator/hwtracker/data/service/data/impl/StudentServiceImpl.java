package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.domain.Student;
import com.regulyator.hwtracker.data.dto.StudentDto;
import com.regulyator.hwtracker.data.exception.EntityNotFoundException;
import com.regulyator.hwtracker.data.repository.StudentRepository;
import com.regulyator.hwtracker.data.service.data.StudentService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto save(@NonNull StudentDto studentDto) {
        final var savedStudent = studentRepository.save(modelMapper.map(studentDto, Student.class));
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public StudentDto getById(@NonNull String id) {
        return studentRepository
                .findById(id)
                .map(student -> modelMapper.map(student, StudentDto.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(@NonNull String id) {
        studentRepository.deleteById(id);
    }
}
