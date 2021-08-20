package com.regulyator.hwtracker.gateway.service;

import com.regulyator.hwtracker.gateway.domain.User;
import com.regulyator.hwtracker.gateway.web.feign.UserServiceApi;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsDaoService implements UserDetailsService {

    private final UserServiceApi userServiceApi;

    public UserDetailsDaoService(UserServiceApi userServiceApi) {
        this.userServiceApi = userServiceApi;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = userServiceApi.loginUser(username);
        System.out.println(u);
        return u;
    }
}
