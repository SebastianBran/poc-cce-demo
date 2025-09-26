package com.cce.directory.application.ports;

import com.cce.directory.domain.entity.DirectoryEntity;

import java.util.List;
import java.util.Optional;

public interface DirectoryService {
    Optional<DirectoryEntity> getById(Long id);
    List<DirectoryEntity> getAll();
    DirectoryEntity create(DirectoryEntity directoryEntity);
    boolean isUserInEntity(String phoneNumber, String entityId);
}
