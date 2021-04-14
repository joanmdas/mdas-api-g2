package com.lasalle.sd2.g2.types.infrastructure.repository;

import com.lasalle.sd2.g2.types.domain.PokemonTypes;
import com.lasalle.sd2.g2.types.infrastructure.conf.TypesConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PokeApiRestCallerTest {

    @BeforeAll
    static void beforeAll() throws IOException {
        TypesConfiguration.setBaseUrl("https://pokeapi.co/api/v2");
    }

    @Test
    void getPokemonTypesExists() {
        List<String> pokemonTypesList = new ArrayList<>();
        pokemonTypesList.add("fire");
        pokemonTypesList.add("flying");

        PokemonTypes pokemonTypesExpected = new PokemonTypes(pokemonTypesList);

        PokeApiRestCaller restCaller = new PokeApiRestCaller();
        PokemonTypes charizardTypes = restCaller.getPokemonTypes("charizard");

        assertNotNull(charizardTypes);
        assertEquals(pokemonTypesExpected, charizardTypes);
    }
}
