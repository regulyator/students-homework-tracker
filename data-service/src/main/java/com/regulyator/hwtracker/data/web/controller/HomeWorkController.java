package com.regulyator.hwtracker.data.web.controller;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.data.service.data.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
public class HomeWorkController {
    private final HomeworkService homeworkService;

    @Autowired
    public HomeWorkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping("/hwtracker/api/data/homeworks/{homeworkId}")
    public ResponseEntity<HomeWorkDto> getHomeWorkById(@PathVariable String homeworkId) {
        return ResponseEntity.ok(homeworkService.getById(homeworkId));
    }

    @GetMapping("/hwtracker/api/data/homeworks")
    public ResponseEntity<Collection<HomeWorkDto>> getAllHomeWorks() {
        return ResponseEntity.ok(homeworkService.getAll());
    }

    @GetMapping("/hwtracker/api/data/homeworks/active/{groupId}")
    public ResponseEntity<Collection<HomeWorkDto>> getAllActiveHomeWorksByGroupId(@PathVariable String groupId) {
        return ResponseEntity.ok(homeworkService.getActiveHomeWorkByGroupId(groupId));
    }

    @PutMapping("/hwtracker/api/data/homeworks")
    public ResponseEntity<HomeWorkDto> updateHomeWork(@RequestBody HomeWorkDto homeWorkDto) {
        return ResponseEntity.ok(homeworkService.save(homeWorkDto));
    }

    @PostMapping("/hwtracker/api/data/homeworks")
    public ResponseEntity<HomeWorkDto> createHomeWork(@RequestBody HomeWorkDto homeWorkDto) {
        final var savedHomeWorkDto = homeworkService.save(homeWorkDto);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedHomeWorkDto.getId()).toUri()).body(savedHomeWorkDto);
    }

    @DeleteMapping("/hwtracker/api/data/homeworks/{homeWorkId}")
    public ResponseEntity<Void> deleteHomeWork(@PathVariable String homeWorkId) {
        homeworkService.removeById(homeWorkId);
        return ResponseEntity.ok().build();
    }
}
