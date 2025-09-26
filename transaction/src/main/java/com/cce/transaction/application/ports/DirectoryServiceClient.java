package com.cce.transaction.application.ports;

import com.cce.transaction.api.dto.response.ExistUserInEntityResponseDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/api/v1/directory")
public interface DirectoryServiceClient {
    @GetExchange("/user-exists-in-entity")
    ExistUserInEntityResponseDto userExistInEntity(
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("entityId") String entityId
    );
}
