package com.regulyator.hwtracker.data.web.controller;

import com.regulyator.hwtracker.data.dto.TeacherDto;
import com.regulyator.hwtracker.data.service.data.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/hwtracker/api/data/teachers/{teacherId}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable String teacherId) {
        return ResponseEntity.ok(teacherService.getById(teacherId));
    }

    @GetMapping("/hwtracker/api/data/teachers")
    public ResponseEntity<Collection<TeacherDto>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAll());
    }

    @PutMapping("/hwtracker/api/data/teachers")
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacherDto) {
        return ResponseEntity.ok(teacherService.save(teacherDto));
    }

    @PostMapping("/hwtracker/api/data/teachers")
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) {
        final var savedTeacherDto = teacherService.save(teacherDto);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedTeacherDto.getId()).toUri()).body(savedTeacherDto);
    }

    @DeleteMapping("/hwtracker/api/data/teachers/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String teacherId) {
        teacherService.removeById(teacherId);
        return ResponseEntity.ok().build();
    }
}
