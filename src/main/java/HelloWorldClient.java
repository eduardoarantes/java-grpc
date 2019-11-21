import com.eduardo.grpc.HelloRequest;
import com.eduardo.grpc.HelloResponse;
import com.eduardo.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorldClient {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(HelloWorldClient.class);

  private HelloServiceGrpc.HelloServiceBlockingStub helloWorldServiceBlockingStub;

  @PostConstruct
  private void init() {
    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 6565).usePlaintext().build();

    helloWorldServiceBlockingStub =
        HelloServiceGrpc.newBlockingStub(managedChannel);
  }

  public String sayHello(String firstName, String lastName) {
    HelloRequest person = HelloRequest.newBuilder().setFirstName(firstName)
        .setLastName(lastName).build();
    LOGGER.info("client sending {}", person);

    HelloResponse greeting =
        helloWorldServiceBlockingStub.hello(person);
    LOGGER.info("client received {}", greeting);

    return greeting.getGreeting();
  }
}
