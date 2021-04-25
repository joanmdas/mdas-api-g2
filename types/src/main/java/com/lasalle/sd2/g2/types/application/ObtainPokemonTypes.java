package com.lasalle.sd2.g2.types.application;

import com.lasalle.sd2.g2.types.application.dto.PokemonTypesResponse;
import com.lasalle.sd2.g2.types.domain.PokemonName;
import com.lasalle.sd2.g2.types.domain.PokemonRepository;
import com.lasalle.sd2.g2.types.domain.PokemonTypes;

public class ObtainPokemonTypes {

    private final PokemonRepository pokemonRepository;

    public ObtainPokemonTypes(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonTypesResponse execute(String pokemonName) {
        PokemonName name = new PokemonName(pokemonName);
        PokemonTypes pokemonTypes = pokemonRepository.getPokemonTypes(name);
        return new PokemonTypesResponse(pokemonTypes.getTypes());
    }
}
