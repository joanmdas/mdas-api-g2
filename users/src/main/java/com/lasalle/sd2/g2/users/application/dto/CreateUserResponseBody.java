package com.lasalle.sd2.g2.users.application.dto;

import java.io.Serializable;

public class CreateUserResponseBody implements Serializable {

    private static final long serialVersionUID = 6498638813242654808L;

    private final String userId;

    public CreateUserResponseBody(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
