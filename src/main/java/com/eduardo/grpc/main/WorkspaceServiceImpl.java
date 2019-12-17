package com.eduardo.grpc.main;

import com.eduardo.grpc.WorkspaceRequest;
import com.eduardo.grpc.WorkspaceResponse;
import com.eduardo.grpc.WorkspaceServiceGrpc;
import com.eduardo.grpc.persistence.WorkspaceRepository;
import com.eduardo.grpc.persistence.model.Workspace;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class WorkspaceServiceImpl
    extends WorkspaceServiceGrpc.WorkspaceServiceImplBase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(WorkspaceServiceImpl.class);


  @Autowired
  private WorkspaceRepository workspaceRepository;

  @Override
  public void createWorkspace(WorkspaceRequest request,
                              StreamObserver<WorkspaceResponse> responseObserver) {
    LOGGER.info("server received {}", request);

    String message = "Creating workspace with type  '" + request.getType() + "' and size: "
        + request.getSize() + "!";
    WorkspaceResponse response =
            WorkspaceResponse.newBuilder().setTaskId(message).build();
    LOGGER.info("server responded {}", response);

    workspaceRepository.save(Workspace.of(request.getType(), request.getSize()));

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
