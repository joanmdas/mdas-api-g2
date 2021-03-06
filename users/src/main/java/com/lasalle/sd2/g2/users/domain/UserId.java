package com.lasalle.sd2.g2.users.domain;

import java.util.UUID;

public class UserId {

    private final UUID id;

    public UserId(UUID id) {
        this.id = id;
    }

    public static UserId create() {
        return new UserId(UUID.randomUUID());
    }

    public String toString() {
        return id.toString();
    }
}
