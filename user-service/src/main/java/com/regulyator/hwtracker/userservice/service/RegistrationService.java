package com.regulyator.hwtracker.userservice.service;

import com.regulyator.hwtracker.userservice.domain.dto.RegisterUserDto;

public interface RegistrationService {

    boolean registerUser(RegisterUserDto registerUserDto);
}
