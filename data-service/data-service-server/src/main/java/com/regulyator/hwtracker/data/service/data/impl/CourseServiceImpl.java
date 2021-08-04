package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.domain.Course;
import com.regulyator.hwtracker.data.dto.CourseDto;
import com.regulyator.hwtracker.data.exception.EntityNotFoundException;
import com.regulyator.hwtracker.data.repository.CourseRepository;
import com.regulyator.hwtracker.data.service.data.CourseService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository,
                             ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDto save(@NonNull CourseDto courseDto) {
        final var savedCourse = courseRepository.save(modelMapper.map(courseDto, Course.class));
        return modelMapper.map(savedCourse, CourseDto.class);
    }

    @Override
    public CourseDto getById(@NonNull String id) {
        return courseRepository
                .findById(id)
                .map(course -> modelMapper.map(course, CourseDto.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll().stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(@NonNull String id) {
        courseRepository.deleteById(id);
    }
}
