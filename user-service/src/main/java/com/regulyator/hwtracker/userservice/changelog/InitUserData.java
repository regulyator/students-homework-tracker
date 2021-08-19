package com.regulyator.hwtracker.userservice.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.regulyator.hwtracker.userservice.domain.User;
import com.regulyator.hwtracker.userservice.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@ChangeLog
public class InitUserData {

    @ChangeSet(order = "001", id = "initUserAdmin", author = "regulyator")
    public void initUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("somestandartpassword"))
                .authorities(Set.of(new SimpleGrantedAuthority("ROLE_ADMIN")))
                .enabled(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .accountNonExpired(true)
                .build());
    }
}
