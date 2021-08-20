package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.domain.Teacher;
import com.regulyator.hwtracker.data.dto.TeacherDto;
import com.regulyator.hwtracker.data.exception.EntityNotFoundException;
import com.regulyator.hwtracker.data.repository.TeacherRepository;
import com.regulyator.hwtracker.data.service.data.TeacherService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public TeacherDto save(@NonNull TeacherDto teacherDto) {
        final var savedTeacher = teacherRepository.save(modelMapper.map(teacherDto, Teacher.class));
        return modelMapper.map(savedTeacher, TeacherDto.class);
    }

    @Override
    public TeacherDto getById(@NonNull String id) {
        return teacherRepository
                .findById(id)
                .map(teacher -> modelMapper.map(teacher, TeacherDto.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public TeacherDto getTeacherByEmail(@NonNull String email) {
        return teacherRepository.
                findTeacherByEmail(email)
                .map(teacher -> modelMapper.map(teacher, TeacherDto.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TeacherDto> getAll() {
        return teacherRepository.findAll().stream()
                .map(teacher -> modelMapper.map(teacher, TeacherDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(@NonNull String id) {
        teacherRepository.deleteById(id);
    }
}
