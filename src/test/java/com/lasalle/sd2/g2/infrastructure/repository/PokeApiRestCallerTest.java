package com.lasalle.sd2.g2.infrastructure.repository;

import com.lasalle.sd2.g2.domain.PokemonTypes;
import com.lasalle.sd2.g2.infrastructure.conf.AppProperties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokeApiRestCallerTest {

    @BeforeAll
    static void beforeAll() throws IOException {
        AppProperties.loadAppProperties();
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
