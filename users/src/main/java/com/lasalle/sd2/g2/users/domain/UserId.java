package com.lasalle.sd2.g2.users.domain;

import java.util.UUID;

public class UserId {

    private final UUID id;

    private UserId(UUID id) {
        this.id = id;
    }

    public static UserId create() {
        return new UserId(UUID.randomUUID());
    }

    public String getUserId() {
        return id.toString();
    }
}
