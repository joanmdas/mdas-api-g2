package com.lasalle.sd2.g2.types.application;

import com.lasalle.sd2.g2.types.application.dto.PokemonTypesResponse;
import com.lasalle.sd2.g2.types.domain.PokemonRepository;
import com.lasalle.sd2.g2.types.domain.PokemonTypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ObtainPokemonTypesTest {

    @Test
    void getPokemonTypes() {
        PokemonRepository repository = mock(PokemonRepository.class);
        List<String> types = new ArrayList<>();
        types.add("bug");
        types.add("poison");

        PokemonTypes pokemonTypes = new PokemonTypes(types);

        when(repository.getPokemonTypes(any())).thenReturn(pokemonTypes);

        ObtainPokemonTypes obtainPokemonTypes = new ObtainPokemonTypes(repository);
        PokemonTypesResponse beedrill = obtainPokemonTypes.execute("beedrill");

        assertNotNull(beedrill);
        assertEquals(types, beedrill.getTypes());
    }
}
