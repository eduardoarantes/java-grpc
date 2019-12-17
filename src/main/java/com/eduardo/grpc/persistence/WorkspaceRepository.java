package com.eduardo.grpc.persistence;

import com.eduardo.grpc.persistence.model.Workspace;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}
