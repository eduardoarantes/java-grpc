package com.eduardo.grpc.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.eduardo.grpc"})
@ComponentScan(basePackages = {"com.eduardo.grpc"})
public class GRPCApplicationConfig {


}
