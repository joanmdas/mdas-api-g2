package com.lasalle.sd2.g2.users.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void create() {
        User user = User.create();
        assertNotNull(user);
        assertNotNull(user.getId());
        assertNotNull(user.getFavorites());
    }

    @Test
    void addFavoritePokemon() {
        User user = User.create();
        user.addFavoritePokemon(23);

        assertEquals(1, user.getFavorites().getPokemons().size());
        assertTrue(user.getFavorites().getPokemons().contains(Pokemon.create(23)));
    }
}
