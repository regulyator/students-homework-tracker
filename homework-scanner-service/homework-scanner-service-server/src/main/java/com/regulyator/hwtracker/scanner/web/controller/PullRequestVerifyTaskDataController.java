package com.regulyator.hwtracker.scanner.web.controller;

import com.regulyator.hwtracker.scanner.dto.PullRequestVerifyTaskDto;
import com.regulyator.hwtracker.scanner.service.data.PullRequestVerifyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.Objects;

@RestController
public class PullRequestVerifyTaskDataController {
    private final PullRequestVerifyTaskService pullRequestVerifyTaskService;

    @Autowired
    public PullRequestVerifyTaskDataController(PullRequestVerifyTaskService pullRequestVerifyTaskService) {
        this.pullRequestVerifyTaskService = pullRequestVerifyTaskService;
    }

    @GetMapping("/hwtracker/api/tracker/tasks/{taskId}")
    public ResponseEntity<PullRequestVerifyTaskDto> getPullRequestVerifyTaskById(@PathVariable String taskId) {
        return ResponseEntity.ok(pullRequestVerifyTaskService.getById(taskId));
    }

    @GetMapping("/hwtracker/api/tracker/tasks")
    public ResponseEntity<Collection<PullRequestVerifyTaskDto>> getAllPullRequestVerifyTasks() {
        return ResponseEntity.ok(pullRequestVerifyTaskService.getAll());
    }

    @GetMapping(value = "/hwtracker/api/tracker/tasks/assignedteacher/{teacherId}")
    public ResponseEntity<Collection<PullRequestVerifyTaskDto>> getAllPullRequestVerifyTasksByAssignedTeacherId(@PathVariable(required = false) String teacherId) {
        final var tasksDto = (Objects.nonNull(teacherId) && !teacherId.isEmpty()) ?
                pullRequestVerifyTaskService.getAllByAssignedTeacherId(teacherId) :
                pullRequestVerifyTaskService.getAllByAssignedTeacherIdIsNull();
        return ResponseEntity.ok(tasksDto);
    }

    @GetMapping(value = "/hwtracker/api/tracker/tasks/student/{studentId}")
    public ResponseEntity<Collection<PullRequestVerifyTaskDto>> getAllPullRequestVerifyTasksByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(pullRequestVerifyTaskService.getAllByStudentId(studentId));
    }

    @GetMapping(value = "/hwtracker/api/tracker/tasks/group/{groupId}")
    public ResponseEntity<Collection<PullRequestVerifyTaskDto>> getAllPullRequestVerifyTasksByGroupId(@PathVariable String groupId) {
        return ResponseEntity.ok(pullRequestVerifyTaskService.getAllByGroupId(groupId));
    }

    @GetMapping(value = "/hwtracker/api/tracker/tasks/homework/{homeworkId}")
    public ResponseEntity<Collection<PullRequestVerifyTaskDto>> getAllPullRequestVerifyTasksByHomeWorkId(@PathVariable String homeworkId) {
        return ResponseEntity.ok(pullRequestVerifyTaskService.getAllByHomeworkId(homeworkId));
    }

    @GetMapping(value = "/hwtracker/api/tracker/tasks/verified/{verified}")
    public ResponseEntity<Collection<PullRequestVerifyTaskDto>> getAllPullRequestVerifyTasksByVerified(@PathVariable Boolean verified) {
        return ResponseEntity.ok(pullRequestVerifyTaskService.getAllByVerified(verified));
    }

    @PutMapping("/hwtracker/api/tracker/tasks")
    public ResponseEntity<PullRequestVerifyTaskDto> updateTask(@RequestBody PullRequestVerifyTaskDto pullRequestVerifyTaskDto) {
        return ResponseEntity.ok(pullRequestVerifyTaskService.save(pullRequestVerifyTaskDto));
    }
}
