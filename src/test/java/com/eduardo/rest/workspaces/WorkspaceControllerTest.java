package com.eduardo.rest.workspaces;

import com.eduardo.grpc.main.WorkspaceClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest()
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class WorkspaceControllerTest {


    @MockBean
    private WorkspaceClient workspaceClient;


    @Test
    public void newWorkspace() {
    }
}