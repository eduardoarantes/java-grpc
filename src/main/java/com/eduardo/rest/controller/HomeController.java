package com.eduardo.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {


    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    String home() throws InterruptedException {
        return "Up and running";
    }
}
