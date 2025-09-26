package com.cce.directory.api.dto.response;

public class ExistUserInEntityResponseDto {
    private Boolean exist;

    public ExistUserInEntityResponseDto() {}

    public ExistUserInEntityResponseDto(Boolean exist) {
        this.exist = exist;
    }

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }
}
