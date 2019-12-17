package com.eduardo.grpc.persistence.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor(staticName="of")
@Entity
public class Workspace {

    @Valid
    @NotNull(message = "type field is required")
    @NonNull
    private String type;

    @Valid
    @NotNull(message = "size field is required")
    @Min(value = 1)
    @NonNull
    private int size;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
