package com.lasalle.sd2.g2.users.infrastructure.dto;

public class GenericErrorResponseBody {

    private final int code;
    private final String message;

    public GenericErrorResponseBody(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
