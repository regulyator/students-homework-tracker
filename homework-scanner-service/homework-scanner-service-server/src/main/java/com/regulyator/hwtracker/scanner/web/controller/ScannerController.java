package com.regulyator.hwtracker.scanner.web.controller;

import com.regulyator.hwtracker.scanner.service.scanner.HomeWorkPullRequestsScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScannerController {
    private final HomeWorkPullRequestsScanner homeWorkPullRequestsScanner;

    @Autowired
    public ScannerController(HomeWorkPullRequestsScanner homeWorkPullRequestsScanner) {
        this.homeWorkPullRequestsScanner = homeWorkPullRequestsScanner;
    }

    @PostMapping(value = "/hwtracker/api/tracker/scan")
    public ResponseEntity<Void> scanHomeWorkPullRequests() {
        homeWorkPullRequestsScanner.scanHomeWorksPullRequests();
        return ResponseEntity.ok().build();
    }
}
