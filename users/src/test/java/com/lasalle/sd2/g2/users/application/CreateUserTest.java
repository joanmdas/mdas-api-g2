package com.lasalle.sd2.g2.users.application;

import com.lasalle.sd2.g2.users.application.dto.CreateUserResponseBody;
import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.UsersRepository;
import com.lasalle.sd2.g2.users.infrastructure.repository.InMemoryUsersRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserTest {

    private static UsersRepository repository;

    @BeforeAll
    static void beforeAll() {
        repository = new InMemoryUsersRepository();
    }

    @Test
    void execute() {
        CreateUser createUser = new CreateUser(repository);
        CreateUserResponseBody responseBody = createUser.execute();
        assertNotNull(responseBody);
        assertFalse(responseBody.getUserId().isBlank());
    }
}
