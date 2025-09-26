package com.cce.directory.application.ports;

import com.cce.directory.domain.entity.DirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<DirectoryEntity, Long> {
    boolean existsByPhoneNumberAndEntityId(String phoneNumber, String entityId);
}
