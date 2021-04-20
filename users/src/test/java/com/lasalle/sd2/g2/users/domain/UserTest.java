package com.lasalle.sd2.g2.users.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Mock
    private FavoritePokemons favoritePokemons;

    @Mock
    private Pokemon pokemon;

    @Test
    void create() {
        User user = User.create();
        assertNotNull(user);
        assertNotNull(user.getUserId());
    }

    @Test
    void addFavoritePokemon() {
        User user = new User(UserId.create(), favoritePokemons);
        user.addFavoritePokemon(pokemon);

        verify(favoritePokemons, times(1)).add(any());
    }
}
