package com.regulyator.hwtracker.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/hwtracker/api/data/**")
                        .uri("lb://hwtracker-data-core"))
                .route(r -> r.path("/hwtracker/api/homeworks/**")
                        .uri("lb://hwtracker-data-homework"))
                .route(r -> r.path("/hwtracker/api/tracker/**")
                        .uri("lb://hwtracker-scanner"))
                .build();
    }
}
