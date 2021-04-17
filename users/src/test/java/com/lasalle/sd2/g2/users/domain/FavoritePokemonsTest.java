package com.lasalle.sd2.g2.users.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FavoritePokemonsTest {

    @Test
    void create() {
        FavoritePokemons favoritePokemons = FavoritePokemons.create();
        assertNotNull(favoritePokemons);
        assertTrue(favoritePokemons.getPokemons().isEmpty());
    }

    @Test
    void add() {
        FavoritePokemons favoritePokemons = FavoritePokemons.create();
        Pokemon testPokemon = Pokemon.create(23);
        favoritePokemons.add(testPokemon);

        assertEquals(1, favoritePokemons.getPokemons().size());
        assertTrue(favoritePokemons.getPokemons().contains(testPokemon));
    }
}
