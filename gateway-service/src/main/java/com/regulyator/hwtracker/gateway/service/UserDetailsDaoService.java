package com.regulyator.hwtracker.gateway.service;

import com.regulyator.hwtracker.gateway.domain.User;
import com.regulyator.hwtracker.gateway.web.feign.UserServiceApi;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsDaoService implements UserDetailsService {
    private final ModelMapper modelMapper;

    private final UserServiceApi userServiceApi;

    public UserDetailsDaoService(ModelMapper modelMapper, UserServiceApi userServiceApi) {
        this.modelMapper = modelMapper;
        this.userServiceApi = userServiceApi;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var userDto = userServiceApi.loginUser(username);
        return modelMapper.map(userDto, User.class);
    }
}
