package com.lasalle.sd2.g2.users.infrastructure.repository;

import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.UserId;
import com.lasalle.sd2.g2.users.domain.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryUsersRepositoryTest {

    @Test
    void saveAndFind() throws UserNotFoundException {
        // Given
        InMemoryUsersRepository repo = new InMemoryUsersRepository();
        User user = User.create();

        // When
        repo.save(user);

        // Then
        assertDoesNotThrow(() -> repo.findByUserId(user.getUserId()));
        assertEquals(user, repo.findByUserId(user.getUserId()));
    }

    @Test
    void notFound() {
        // Given
        InMemoryUsersRepository repo = new InMemoryUsersRepository();
        UserId userId = UserId.create();

        // Then
        UserNotFoundException userNotFoundException = assertThrows(UserNotFoundException.class, () -> repo.findByUserId(userId));
        assertEquals("User " + userId + " not found", userNotFoundException.getMessage());
    }
}
