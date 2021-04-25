package com.lasalle.sd2.g2.pokemons.application;

import com.lasalle.sd2.g2.pokemons.application.dto.PokemonDetailsResponse;
import com.lasalle.sd2.g2.pokemons.domain.PokemonDetails;
import com.lasalle.sd2.g2.pokemons.domain.PokemonRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetPokemonDetailsTest {

    @Test
    void execute() {
        PokemonRepository repository = mock(PokemonRepository.class);
        List<String> types = new ArrayList<>();
        types.add("bug");
        types.add("poison");
        PokemonDetails pokemonDetails = new PokemonDetails(15, "beedrill", types);

        when(repository.getPokemonDetails(any())).thenReturn(pokemonDetails);

        GetPokemonDetails getPokemonDetails = new GetPokemonDetails(repository);
        PokemonDetailsResponse response = getPokemonDetails.execute(15);

        assertNotNull(response);
        assertEquals(15, response.getId());
        assertEquals("beedrill", response.getName());
        assertEquals(types, response.getTypes());
    }
}
