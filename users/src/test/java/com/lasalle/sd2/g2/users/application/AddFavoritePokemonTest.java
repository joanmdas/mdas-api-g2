package com.lasalle.sd2.g2.users.application;

import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.UserNotFoundException;
import com.lasalle.sd2.g2.users.domain.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddFavoritePokemonTest {

    @Mock
    private UsersRepository repository;

    @Mock
    private User user;

    @Test
    void executeThrowsUserNotFoundException() throws UserNotFoundException {
        when(repository.findByUserId(any())).thenThrow(UserNotFoundException.class);

        AddFavoritePokemon addFavoritePokemon = new AddFavoritePokemon(repository);
        assertThrows(UserNotFoundException.class, () -> addFavoritePokemon.execute(UUID.randomUUID().toString(), 1));
    }

    @Test
    void executeAddedSuccessfully() throws UserNotFoundException {
        when(repository.findByUserId(any())).thenReturn(user);
        doNothing().when(repository).save(user);

        AddFavoritePokemon addFavoritePokemon = new AddFavoritePokemon(repository);
        addFavoritePokemon.execute(UUID.randomUUID().toString(), 123);

        verify(repository, times(1)).save(any());
    }
}
