package com.regulyator.hwtracker.data.web.controller;

import com.regulyator.hwtracker.data.dto.StudentDto;
import com.regulyator.hwtracker.data.service.data.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/hwtracker/api/data/students/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String studentId) {
        return ResponseEntity.ok(studentService.getById(studentId));
    }

    @GetMapping("/hwtracker/api/data/students")
    public ResponseEntity<Collection<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PutMapping("/hwtracker/api/data/students")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.save(studentDto));
    }

    @PostMapping("/hwtracker/api/data/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        final var savedStudentDto = studentService.save(studentDto);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedStudentDto.getId()).toUri()).body(savedStudentDto);
    }

    @DeleteMapping("/hwtracker/api/data/students/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String studentId) {
        studentService.removeById(studentId);
        return ResponseEntity.ok().build();
    }
}
