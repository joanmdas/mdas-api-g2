package com.lasalle.sd2.g2.users.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserIdTest {

    @Test
    void create() {
        UserId userId = UserId.create();
        assertNotNull(userId.getUserId());
    }
}
