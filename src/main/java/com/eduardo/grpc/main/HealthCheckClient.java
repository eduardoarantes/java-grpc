package com.eduardo.grpc.main;

import grpc.health.v1.HealthCheckGrpc;
import grpc.health.v1.Service;
import grpc.health.v1.Status;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class HealthCheckClient {

    private int serverPort = 6565;

    private String serverLocation= "localhost";

    private final ManagedChannel channel;
    private final HealthCheckGrpc.HealthCheckBlockingStub stub;
    private String name;

    public HealthCheckClient() {
        this.channel = ManagedChannelBuilder.forAddress(serverLocation, serverPort)
                // Channels are secure by default (via SSL/TLS).
                // For the example we disable TLS to avoid needing certificates.
                .usePlaintext()
                .build();
        this.stub = HealthCheckGrpc.newBlockingStub(channel);
    }

    public Status healthcheck() throws InterruptedException {
        log.info("Health checking server ...");

        // build message
        Service service = Service.newBuilder().setService("server").build();

       return stub.check(service);
    }
}