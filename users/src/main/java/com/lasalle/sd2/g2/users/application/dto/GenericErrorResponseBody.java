package com.lasalle.sd2.g2.users.application.dto;

public class GenericErrorResponseBody {

    private final String message;

    public GenericErrorResponseBody(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
