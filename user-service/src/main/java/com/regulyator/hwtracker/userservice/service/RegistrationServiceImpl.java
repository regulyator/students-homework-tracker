package com.regulyator.hwtracker.userservice.service;

import com.regulyator.hwtracker.userservice.domain.dto.RegisterUserDto;
import com.regulyator.hwtracker.userservice.domain.stored.User;
import com.regulyator.hwtracker.userservice.repository.UserRepository;
import com.regulyator.hwtracker.userservice.service.external.DataExchangeApiServiceClient;
import lombok.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Objects;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final DataExchangeApiServiceClient dataExchangeApiServiceClient;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(DataExchangeApiServiceClient dataExchangeApiServiceClient,
                                   UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.dataExchangeApiServiceClient = dataExchangeApiServiceClient;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(@NonNull RegisterUserDto registerUserDto) {
        final var teacher = dataExchangeApiServiceClient.getTeacherByEmail(registerUserDto.getTeacherEmail());
        if (Objects.nonNull(teacher)
                && !userRepository.existsUserByUsername(registerUserDto.getTeacherEmail())) {
            final var decodedPasswordString = new String(Base64.getDecoder().decode(registerUserDto.getPassword()));
            userRepository.save(User.builder()
                    .teacherId(teacher.getId())
                    .username(registerUserDto.getTeacherEmail())
                    .password(passwordEncoder.encode(decodedPasswordString))
                    .role("ROLE_TEACHER")
                    .enabled(true)
                    .credentialsNonExpired(true)
                    .accountNonLocked(true)
                    .accountNonExpired(true)
                    .build());

            return true;
        }
        return false;
    }
}
