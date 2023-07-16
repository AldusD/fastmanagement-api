package com.managecorp.fastmanagementapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public String checkApi() throws InterruptedException {
        return "Chill, everthing is fine";
    }
}
