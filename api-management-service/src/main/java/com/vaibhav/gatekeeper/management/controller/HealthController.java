package com.vaibhav.gatekeeper.management.controller;

import com.vaibhav.gatekeeper.management.dto.responseDto.HealthResponse;
import com.vaibhav.gatekeeper.management.service.HealthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/health")
public class HealthController {

    public HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping
    public ResponseEntity<HealthResponse> health() {
        String dbStatus = healthService.getHealth();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HealthResponse(
                        "UP",
                        dbStatus,
                        LocalDateTime.now()
                ));
    }
}
