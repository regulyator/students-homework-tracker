package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.dto.CourseDto;
import com.regulyator.hwtracker.data.repository.CourseRepository;
import com.regulyator.hwtracker.data.service.data.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
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
        return null;
    }

    @Override
    public void removeById(String id) {

    }
}
