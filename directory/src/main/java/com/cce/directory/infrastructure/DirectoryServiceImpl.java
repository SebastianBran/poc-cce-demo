package com.cce.directory.infrastructure;

import com.cce.directory.application.ports.DirectoryRepository;
import com.cce.directory.application.ports.DirectoryService;
import com.cce.directory.domain.entity.DirectoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    private static final Logger logger = LoggerFactory.getLogger(DirectoryServiceImpl.class);

    private final DirectoryRepository directoryRepository;

    public DirectoryServiceImpl(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @Override
    public Optional<DirectoryEntity> getById(Long id) {
        logger.info("Get Directory registry with id #{}", id);
        return this.directoryRepository.findById(id);
    }

    @Override
    public List<DirectoryEntity> getAll() {
        logger.info("Get All Directory registries");
        return this.directoryRepository.findAll();
    }

    @Override
    public DirectoryEntity create(DirectoryEntity directoryEntity) {
        logger.info("Create Directory registry");
        return this.directoryRepository.save(directoryEntity);
    }

    @Override
    public boolean isUserInEntity(String phoneNumber, String entityId) {
        logger.info("Validating if user with phone number {} exists in entity with id {}", phoneNumber, entityId);
        return this.directoryRepository.existsByPhoneNumberAndEntityId(phoneNumber, entityId);
    }
}
