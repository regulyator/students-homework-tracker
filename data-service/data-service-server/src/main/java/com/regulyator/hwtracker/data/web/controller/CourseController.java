package com.regulyator.hwtracker.data.web.controller;

import com.regulyator.hwtracker.data.dto.CourseDto;
import com.regulyator.hwtracker.data.service.data.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/hwtracker/api/data/courses/{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String courseId) {
        return ResponseEntity.ok(courseService.getById(courseId));
    }

    @GetMapping("/hwtracker/api/data/courses")
    public ResponseEntity<Collection<CourseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @PutMapping("/hwtracker/api/data/courses")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto) {
        return ResponseEntity.ok(courseService.save(courseDto));
    }

    @PostMapping("/hwtracker/api/data/courses")
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        final var savedCourseDto = courseService.save(courseDto);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedCourseDto.getId()).toUri()).body(savedCourseDto);
    }

    @DeleteMapping("/hwtracker/api/data/courses/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseId) {
        courseService.removeById(courseId);
        return ResponseEntity.ok().build();
    }
}
