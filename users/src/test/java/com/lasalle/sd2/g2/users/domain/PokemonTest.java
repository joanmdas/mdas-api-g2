package com.lasalle.sd2.g2.users.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    void create() {
        Pokemon pokemon = Pokemon.create(1);
        assertNotNull(pokemon);
        assertEquals(1, pokemon.getId());
    }
}
