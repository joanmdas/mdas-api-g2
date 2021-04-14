package com.lasalle.sd2.g2.types.application;

import com.lasalle.sd2.g2.types.domain.PokemonRepository;
import com.lasalle.sd2.g2.types.domain.PokemonTypes;

public class ObtainPokemonTypes {

    private final PokemonRepository pokemonRepository;

    public ObtainPokemonTypes(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonTypes getPokemonTypes(String pokemonName) {
        return pokemonRepository.getPokemonTypes(pokemonName);
    }
}
