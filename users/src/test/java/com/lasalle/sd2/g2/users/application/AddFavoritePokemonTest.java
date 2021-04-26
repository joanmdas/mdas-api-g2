package com.lasalle.sd2.g2.users.application;

import com.lasalle.sd2.g2.users.application.dto.AddFavoritePokemonRequestBody;
import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.exceptions.UserNotFoundException;
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

        AddFavoritePokemonRequestBody requestBody = new AddFavoritePokemonRequestBody(1);
        AddFavoritePokemon addFavoritePokemon = new AddFavoritePokemon(repository);
        assertThrows(UserNotFoundException.class, () -> addFavoritePokemon.execute(UUID.randomUUID().toString(), requestBody));
    }

    @Test
    void executeAddedSuccessfully() throws UserNotFoundException {
        when(repository.findByUserId(any())).thenReturn(user);
        doNothing().when(repository).save(user);

        AddFavoritePokemonRequestBody requestBody = new AddFavoritePokemonRequestBody(123);
        AddFavoritePokemon addFavoritePokemon = new AddFavoritePokemon(repository);

        addFavoritePokemon.execute(UUID.randomUUID().toString(), requestBody);

        verify(repository, times(1)).save(any());
    }
}
