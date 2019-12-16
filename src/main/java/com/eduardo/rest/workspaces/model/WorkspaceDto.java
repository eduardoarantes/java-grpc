package com.eduardo.rest.workspaces.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class WorkspaceDto {

    @Valid
    @NotNull(message = "type field is required")
    private String type;

    @Valid
    @NotNull(message = "size field is required")
    @Size(min = 1)
    private int size;
}
