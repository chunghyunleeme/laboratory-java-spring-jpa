package com.chunghyun.laboratory.monitor.ui;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "monitor", description = "the monitor API")
@RequestMapping("/api/v1/monitors/health")
@RestController
public class HealthCheckController {

    @Operation(summary = "Health check")
    @ApiResponse(responseCode = "200", description = "successful operation"
    )
    @GetMapping("")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().build();
    }
}
