package com.regulyator.hwtracker.homework.web.controller;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.homework.service.data.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
public class HomeWorkController {
    private final HomeWorkService homeWorkService;

    @Autowired
    public HomeWorkController(HomeWorkService homeWorkService) {
        this.homeWorkService = homeWorkService;
    }

    @GetMapping("/hwtracker/api/homeworks/{homeWorkId}")
    public ResponseEntity<HomeWorkDto> getHomeWorkById(@PathVariable String homeWorkId) {
        return ResponseEntity.ok(homeWorkService.getById(homeWorkId));
    }

    @GetMapping("/hwtracker/api/homeworks")
    public ResponseEntity<Collection<HomeWorkDto>> getAllHomeWorks(@RequestParam(required = false, defaultValue = "false") Boolean active) {
        return ResponseEntity.ok(active ? homeWorkService.getAllActiveHomeworks() : homeWorkService.getAll());
    }

    @GetMapping("/hwtracker/api/homeworks/group/{groupId}")
    public ResponseEntity<Collection<HomeWorkDto>> getAllGroupHomeWorks(@PathVariable String groupId) {
        return ResponseEntity.ok(homeWorkService.getAllGroupHomeWork(groupId));
    }

    @PutMapping("/hwtracker/api/homeworks")
    public ResponseEntity<HomeWorkDto> updateHomeWork(@RequestBody HomeWorkDto homeWorkDto) {
        return ResponseEntity.ok(homeWorkService.save(homeWorkDto));
    }

    @PostMapping("/hwtracker/api/homeworks")
    public ResponseEntity<HomeWorkDto> createHomeWork(@RequestBody HomeWorkDto homeWorkDto) {
        final var savedHomeWorkDto = homeWorkService.save(homeWorkDto);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedHomeWorkDto.getId()).toUri()).body(savedHomeWorkDto);
    }

    @DeleteMapping("/hwtracker/api/homeworks/{homeWorkId}")
    public ResponseEntity<Void> deleteHomeWork(@PathVariable String homeWorkId) {
        homeWorkService.removeById(homeWorkId);
        return ResponseEntity.ok().build();
    }

}
