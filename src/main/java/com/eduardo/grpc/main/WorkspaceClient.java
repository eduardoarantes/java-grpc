package com.eduardo.grpc.main;

import com.eduardo.grpc.WorkspaceRequest;
import com.eduardo.grpc.WorkspaceResponse;
import com.eduardo.grpc.WorkspaceServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WorkspaceClient {

    private int serverPort = 6565;

    private String serverLocation= "localhost";


    private static final Logger LOGGER =
            LoggerFactory.getLogger(WorkspaceClient.class);

    private WorkspaceServiceGrpc.WorkspaceServiceBlockingStub workspaceService;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress(serverLocation, serverPort).usePlaintext().build();

        workspaceService =
                WorkspaceServiceGrpc.newBlockingStub(managedChannel);
    }

    public String createWorkspace(String type, int size) {
        WorkspaceRequest workspace = WorkspaceRequest.newBuilder().setType(type)
                .setSize(size).build();
        LOGGER.info("client sending {}", workspace);

        WorkspaceResponse response =
                workspaceService.createWorkspace(workspace);
        LOGGER.info("client received {}", response);

        return response.getTaskId();
    }
}
