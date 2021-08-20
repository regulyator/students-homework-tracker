package com.regulyator.hwtracker.userservice.web.controller;

import com.regulyator.hwtracker.userservice.domain.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserDetailsService userDetailsService;
    private final ModelMapper modelMapper;

    public LoginController(UserDetailsService userDetailsService,
                           ModelMapper modelMapper) {
        this.userDetailsService = userDetailsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/hwtracker/api/user/login/{userLogin}")
    public ResponseEntity<UserDto> loginUser(@PathVariable String userLogin) {
        try {
            return ResponseEntity.ok(modelMapper.map(userDetailsService.loadUserByUsername(userLogin), UserDto.class));
        } catch (UsernameNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
