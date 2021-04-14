package com.lasalle.sd2.g2.types.infrastructure.dto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PokemonTypesDtoTest {

    private static PokemonTypesDto pokemonTypesDtoCharizard;

    @BeforeAll
    static void beforeAll() {
        PokemonTypeDto fire = new PokemonTypeDto();
        fire.setName("fire");
        PokemonTypeDto flying = new PokemonTypeDto();
        flying.setName("flying");

        PokemonTypesInfoDto pokemonTypesInfoFire = new PokemonTypesInfoDto();
        pokemonTypesInfoFire.setType(fire);
        PokemonTypesInfoDto pokemonTypesInfoFlying = new PokemonTypesInfoDto();
        pokemonTypesInfoFlying.setType(flying);

        List<PokemonTypesInfoDto> pokemonTypesInfoDtoList = new ArrayList<>();
        pokemonTypesInfoDtoList.add(pokemonTypesInfoFire);
        pokemonTypesInfoDtoList.add(pokemonTypesInfoFlying);

        pokemonTypesDtoCharizard = new PokemonTypesDto();
        pokemonTypesDtoCharizard.setTypes(pokemonTypesInfoDtoList);
    }

    @Test
    void getPokemonTypes() {
        List<String> pokemonTypesListExpected = new ArrayList<>();
        pokemonTypesListExpected.add("fire");
        pokemonTypesListExpected.add("flying");

        List<String> pokemonTypesList = pokemonTypesDtoCharizard.getPokemonTypes();

        assertNotNull(pokemonTypesList);
        assertEquals(pokemonTypesListExpected, pokemonTypesList);
    }
}
