package com.lasalle.sd2.g2.users.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FavoritePokemonsTest {

    @Mock
    private Pokemon pokemon;

    @Test
    void create() {
        FavoritePokemons favoritePokemons = FavoritePokemons.create();
        assertNotNull(favoritePokemons);
    }

    @Test
    void add() {
        Set<Pokemon> pokemons = new HashSet<>();
        FavoritePokemons favoritePokemons = new FavoritePokemons(pokemons);
        favoritePokemons.add(pokemon);

        assertNotNull(favoritePokemons);
        assertEquals(1, pokemons.size());
        assertTrue(pokemons.contains(pokemon));
    }
}
