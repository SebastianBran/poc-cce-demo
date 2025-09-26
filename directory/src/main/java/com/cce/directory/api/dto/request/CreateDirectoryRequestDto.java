package com.cce.directory.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateDirectoryRequestDto {
    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String phoneNumber;

    @NotNull
    @NotBlank
    private String entityId;

    public CreateDirectoryRequestDto() {}

    public CreateDirectoryRequestDto(String phoneNumber, String entityId) {
        this.phoneNumber = phoneNumber;
        this.entityId = entityId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
