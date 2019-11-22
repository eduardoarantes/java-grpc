package com.eduardo.rest.controller;

import com.eduardo.grpc.main.HealthCheckClient;
import grpc.health.v1.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {


    @Autowired
    private HealthCheckClient healthCheckClient;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    String status() throws InterruptedException {
        final Status healthcheck = healthCheckClient.healthcheck();
        return healthcheck.toString();
    }
}
