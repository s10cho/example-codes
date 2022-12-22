package org.example.spring.cloud.eureka.client.instance.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instances")
public class InstanceResource {

    private final DiscoveryClient discoveryClient;

    @GetMapping
    public List<String> findAll() {
        return this.discoveryClient.getServices();
    }

    @GetMapping("{applicationName}")
    public List<ServiceInstance> find(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
