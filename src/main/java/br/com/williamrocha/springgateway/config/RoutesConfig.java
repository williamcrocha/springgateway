package br.com.williamrocha.springgateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Slf4j
@Configuration
public class RoutesConfig {

    private static final String HTTP_HTTP_BIN_ORG = "http://httpbin.org";

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        log.info("Initializing routes");
        return builder.routes()
                .route(r -> r.path("/get")
                        .filters(f -> f.addRequestHeader("Hello","William Rocha"))
                        .uri(HTTP_HTTP_BIN_ORG+":80")
                )
                .build();
    }

}
