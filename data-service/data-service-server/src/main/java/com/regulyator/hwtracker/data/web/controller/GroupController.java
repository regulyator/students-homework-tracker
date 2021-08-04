package com.regulyator.hwtracker.data.web.controller;

import com.regulyator.hwtracker.data.dto.GroupDto;
import com.regulyator.hwtracker.data.service.data.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/hwtracker/api/data/groups/{groupId}")
    public ResponseEntity<GroupDto> getGroupDtoById(@PathVariable String groupId) {
        return ResponseEntity.ok(groupService.getById(groupId));
    }

    @GetMapping("/hwtracker/api/data/groups")
    public ResponseEntity<Collection<GroupDto>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAll());
    }

    @PutMapping("/hwtracker/api/data/groups")
    public ResponseEntity<GroupDto> updateGroup(@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(groupService.save(groupDto));
    }

    @PostMapping("/hwtracker/api/data/groups")
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupDto) {
        final var savedGroupDto = groupService.save(groupDto);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedGroupDto.getId()).toUri()).body(savedGroupDto);
    }

    @DeleteMapping("/hwtracker/api/data/groups/{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable String groupId) {
        groupService.removeById(groupId);
        return ResponseEntity.ok().build();
    }
}
