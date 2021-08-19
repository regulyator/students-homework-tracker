package com.regulyator.hwtracker.userservice.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/hwtracker/api/user/login")
    public ResponseEntity<Void> loginUser() {
        return ResponseEntity.ok().build();
    }
}
