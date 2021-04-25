package com.lasalle.sd2.g2.types.infrastructure.dto;

import com.lasalle.sd2.g2.types.infrastructure.repository.pokeapi.PokeApiTypeResponse;
import com.lasalle.sd2.g2.types.infrastructure.repository.pokeapi.PokeApiTypesResponse;
import com.lasalle.sd2.g2.types.infrastructure.repository.pokeapi.PokeApiTypesInfoResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PokeApiTypesResponseTest {

    private static PokeApiTypesResponse pokeApiTypesResponseCharizard;

    @BeforeAll
    static void beforeAll() {
        PokeApiTypeResponse fire = new PokeApiTypeResponse();
        fire.setName("fire");
        PokeApiTypeResponse flying = new PokeApiTypeResponse();
        flying.setName("flying");

        PokeApiTypesInfoResponse pokemonTypesInfoFire = new PokeApiTypesInfoResponse();
        pokemonTypesInfoFire.setType(fire);
        PokeApiTypesInfoResponse pokemonTypesInfoFlying = new PokeApiTypesInfoResponse();
        pokemonTypesInfoFlying.setType(flying);

        List<PokeApiTypesInfoResponse> pokeApiTypesInfoResponseList = new ArrayList<>();
        pokeApiTypesInfoResponseList.add(pokemonTypesInfoFire);
        pokeApiTypesInfoResponseList.add(pokemonTypesInfoFlying);

        pokeApiTypesResponseCharizard = new PokeApiTypesResponse();
        pokeApiTypesResponseCharizard.setTypes(pokeApiTypesInfoResponseList);
    }

    @Test
    void getPokemonTypes() {
        List<String> pokemonTypesListExpected = new ArrayList<>();
        pokemonTypesListExpected.add("fire");
        pokemonTypesListExpected.add("flying");

        List<String> pokemonTypesList = pokeApiTypesResponseCharizard.getPokemonTypes();

        assertNotNull(pokemonTypesList);
        assertEquals(pokemonTypesListExpected, pokemonTypesList);
    }
}
