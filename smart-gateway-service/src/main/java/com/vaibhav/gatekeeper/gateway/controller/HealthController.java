package com.vaibhav.gatekeeper.gateway.controller;

import com.vaibhav.gatekeeper.gateway.dto.responseDto.HealthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    private String serviceName;
    private String serviceDescription;

    public HealthController(@Value("${info.app.name}") String serviceDescription,
                            @Value("${info.app.description}")String serviceName) {
        this.serviceDescription = serviceDescription;
        this.serviceName = serviceName;
    }

    @GetMapping
    public ResponseEntity<HealthResponse> health() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new HealthResponse(serviceName, serviceDescription, "UP")
                );
    }

}
