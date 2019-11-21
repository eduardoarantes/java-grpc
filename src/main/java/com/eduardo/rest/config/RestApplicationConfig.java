package com.eduardo.rest.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.eduardo.rest"})
@ComponentScan(basePackages = {"com.eduardo.rest"})
public class RestApplicationConfig {


}
