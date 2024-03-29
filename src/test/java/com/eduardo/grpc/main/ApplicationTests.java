package com.eduardo.grpc.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

  @Autowired
  private WorkspaceClient helloWorldClient;

  @Test
  public void testSayHello() {
    assertThat(helloWorldClient.createWorkspace("windows", 10))
        .isEqualTo("Creating workspace with type  'windows' and size: 10!");
  }
}
