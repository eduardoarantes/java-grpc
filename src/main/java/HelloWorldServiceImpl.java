import com.eduardo.grpc.HelloRequest;
import com.eduardo.grpc.HelloResponse;
import com.eduardo.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class HelloWorldServiceImpl
    extends HelloServiceGrpc.HelloServiceImplBase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(HelloWorldServiceImpl.class);

  @Override
  public void hello(HelloRequest request,
                       StreamObserver<HelloResponse> responseObserver) {
    LOGGER.info("server received {}", request);

    String message = "Hello " + request.getFirstName() + " "
        + request.getLastName() + "!";
    HelloResponse greeting =
            HelloResponse.newBuilder().setGreeting(message).build();
    LOGGER.info("server responded {}", greeting);

    responseObserver.onNext(greeting);
    responseObserver.onCompleted();
  }
}
