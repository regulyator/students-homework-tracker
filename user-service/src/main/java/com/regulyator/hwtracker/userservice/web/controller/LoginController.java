package com.regulyator.hwtracker.userservice.web.controller;

import com.regulyator.hwtracker.userservice.domain.dto.RegisterUserDto;
import com.regulyator.hwtracker.userservice.domain.dto.UserDto;
import com.regulyator.hwtracker.userservice.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private final UserDetailsService userDetailsService;
    private final ModelMapper modelMapper;
    private final RegistrationService registrationService;

    public LoginController(UserDetailsService userDetailsService,
                           ModelMapper modelMapper, RegistrationService registrationService) {
        this.userDetailsService = userDetailsService;
        this.modelMapper = modelMapper;
        this.registrationService = registrationService;
    }

    @GetMapping("/hwtracker/api/user/login/{userLogin}")
    public ResponseEntity<UserDto> loginUser(@PathVariable String userLogin) {
        try {
            return ResponseEntity.ok(modelMapper.map(userDetailsService.loadUserByUsername(userLogin), UserDto.class));
        } catch (UsernameNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/hwtracker/api/user/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserDto registerUserDto) {
        final var created = registrationService.registerUser(registerUserDto);
        return created ? ResponseEntity.ok().build() : ResponseEntity.unprocessableEntity().build();
    }
}

