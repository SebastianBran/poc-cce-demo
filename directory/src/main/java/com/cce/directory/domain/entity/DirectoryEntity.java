package com.cce.directory.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "directory")
public class DirectoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Column(name = "entity_id", nullable = false)
    private String entityId;

    public DirectoryEntity() {}

    public DirectoryEntity(String phoneNumber, String entityId) {
        this.phoneNumber = phoneNumber;
        this.entityId = entityId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
