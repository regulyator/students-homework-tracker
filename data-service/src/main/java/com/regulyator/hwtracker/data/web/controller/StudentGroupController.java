package com.regulyator.hwtracker.data.web.controller;

import com.regulyator.hwtracker.data.dto.StudentGroupDto;
import com.regulyator.hwtracker.data.service.data.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
public class StudentGroupController {
    private final StudentGroupService studentGroupService;

    @Autowired
    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping("/hwtracker/api/data/studentgroups/{studentGroupId}")
    public ResponseEntity<StudentGroupDto> getStudentGroupById(@PathVariable String studentGroupId) {
        return ResponseEntity.ok(studentGroupService.getById(studentGroupId));
    }

    @GetMapping("/hwtracker/api/data/studentgroups")
    public ResponseEntity<Collection<StudentGroupDto>> getAllStudentGroups() {
        return ResponseEntity.ok(studentGroupService.getAll());
    }

    @PutMapping("/hwtracker/api/data/studentgroups")
    public ResponseEntity<StudentGroupDto> updateStudentGroup(@RequestBody StudentGroupDto studentGroupDto) {
        return ResponseEntity.ok(studentGroupService.save(studentGroupDto));
    }

    @PostMapping("/hwtracker/api/data/studentgroups")
    public ResponseEntity<StudentGroupDto> createStudentGroup(@RequestBody StudentGroupDto studentGroupDto) {
        final var savedStudentGroupDto = studentGroupService.save(studentGroupDto);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedStudentGroupDto.getId()).toUri()).body(savedStudentGroupDto);
    }

    @DeleteMapping("/hwtracker/api/data/studentgroups/{studentGroupId}")
    public ResponseEntity<Void> deleteStudentGroup(@PathVariable String studentGroupId) {
        studentGroupService.removeById(studentGroupId);
        return ResponseEntity.ok().build();
    }
}
