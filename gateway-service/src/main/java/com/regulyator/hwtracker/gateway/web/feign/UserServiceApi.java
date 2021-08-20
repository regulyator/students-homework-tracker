package com.regulyator.hwtracker.gateway.web.feign;

import com.regulyator.hwtracker.gateway.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserServiceApi {

    @GetMapping("/hwtracker/api/user/login/{userLogin}")
    User loginUser(@PathVariable String userLogin);
}
