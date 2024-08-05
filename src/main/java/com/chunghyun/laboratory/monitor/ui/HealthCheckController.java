package com.chunghyun.laboratory.monitor.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/monitors/health")
@RestController
public class HealthCheckController {
    @GetMapping("")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().build();
    }
}
