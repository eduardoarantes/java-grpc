package com.eduardo.grpc.main;

import grpc.health.v1.HealthCheckGrpc;
import grpc.health.v1.Service;
import grpc.health.v1.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

import java.util.Random;

@Slf4j
@GRpcService
public class HealthCheckServiceImpl extends HealthCheckGrpc.HealthCheckImplBase {

    @Override
    public void check(Service request, StreamObserver<Status> responseObserver) {
        Status.ServingStatus status = Status.ServingStatus.forNumber(new Random().nextInt(3));
        final Status.Builder replyBuilder = Status.newBuilder().setStatus(status);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}