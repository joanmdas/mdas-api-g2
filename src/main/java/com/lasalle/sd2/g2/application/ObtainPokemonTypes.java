package com.lasalle.sd2.g2.application;

import com.lasalle.sd2.g2.domain.PokemonRepository;
import com.lasalle.sd2.g2.domain.PokemonTypes;

public class ObtainPokemonTypes {

    private final PokemonRepository pokemonRepository;

    public ObtainPokemonTypes(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonTypes getPokemonTypes(String pokemonName) {
        return pokemonRepository.getPokemonTypes(pokemonName);
    }
}
