package com.cce.directory.api.controllers;

import com.cce.directory.api.dto.request.CreateDirectoryRequestDto;
import com.cce.directory.api.dto.response.ExistUserInEntityResponseDto;
import com.cce.directory.application.ports.DirectoryService;
import com.cce.directory.domain.entity.DirectoryEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/directory")
public class DirectoryController {
    private final DirectoryService directoryService;

    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @GetMapping("{directoryId}")
    public Optional<DirectoryEntity> getById(@PathVariable Long directoryId) {
        return this.directoryService.getById(directoryId);
    }

    @GetMapping()
    public List<DirectoryEntity> getAll() {
        return this.directoryService.getAll();
    }

    @GetMapping("/user-exists-in-entity")
    public ExistUserInEntityResponseDto existInEntity(@RequestParam String phoneNumber, @RequestParam String entityId) {
        Boolean exist = this.directoryService.isUserInEntity(phoneNumber, entityId);
        return new ExistUserInEntityResponseDto(exist);
    }

    @PostMapping()
    public DirectoryEntity create(@Valid @RequestBody CreateDirectoryRequestDto createDirectoryRequestDto) {
        DirectoryEntity directoryEntity =
                new DirectoryEntity(createDirectoryRequestDto.getPhoneNumber(),
                        createDirectoryRequestDto.getEntityId());
        return this.directoryService.create(directoryEntity);
    }
}
