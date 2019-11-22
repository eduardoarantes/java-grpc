package com.eduardo.rest.controller;

import com.eduardo.grpc.main.WorkspaceClient;
import com.eduardo.rest.model.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {


    @Autowired
    private WorkspaceClient workspaceClient;

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    String newWorkspace(@RequestBody Workspace newWorkspace) {

        return workspaceClient.createWorkspace(newWorkspace.getType(), newWorkspace.getSize());
    }
}
