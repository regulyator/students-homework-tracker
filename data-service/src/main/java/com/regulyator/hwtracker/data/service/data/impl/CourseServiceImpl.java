package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.dto.CourseDto;
import com.regulyator.hwtracker.data.repository.CourseRepository;
import com.regulyator.hwtracker.data.service.data.CourseService;
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
    public CourseDto save(CourseDto entity) {
        return null;
    }

    @Override
    public CourseDto getById(String id) {
        return null;
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll().stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(String id) {
        courseRepository.deleteById(id);
    }
}
