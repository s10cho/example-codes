package org.example.spring.multimodule.home.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(HomeServiceProperties.class)
public class HomeService {

    private final HomeServiceProperties serviceProperties;

    public String message() {
        return this.serviceProperties.getMessage();
    }
}
