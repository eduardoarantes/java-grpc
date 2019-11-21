package com.eduardo.grpc.main;

import com.eduardo.rest.model.Workspace;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkspaceController {

    @PostMapping("/")
    String newWorkspace(@RequestBody Workspace newWorkspace) {
        return "";
    }
}
