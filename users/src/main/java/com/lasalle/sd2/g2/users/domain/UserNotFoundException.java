package com.lasalle.sd2.g2.users.domain;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = -7258477226628760992L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
