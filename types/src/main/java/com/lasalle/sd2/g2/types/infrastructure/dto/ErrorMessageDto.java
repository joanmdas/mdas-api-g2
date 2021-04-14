package com.lasalle.sd2.g2.types.infrastructure.dto;

public class ErrorMessageDto {

    private final String message;

    public ErrorMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
