package com.eduardo.grpc.main;

import grpc.health.v1.HealthCheckGrpc;
import grpc.health.v1.HealthCheckOuterClass;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

import java.util.Random;

@Slf4j
@GRpcService
public class HealthCheck extends HealthCheckGrpc.HealthCheckImplBase {


}