package com.lasalle.sd2.g2.pokemons.application;

import com.lasalle.sd2.g2.pokemons.domain.PokemonDetails;
import com.lasalle.sd2.g2.pokemons.domain.PokemonId;
import com.lasalle.sd2.g2.pokemons.domain.PokemonRepository;

public class GetPokemonDetails {

    private final PokemonRepository repository;

    public GetPokemonDetails(PokemonRepository repository) {
        this.repository = repository;
    }

    public PokemonDetails execute(PokemonId pokemonId) {
        return repository.getPokemonDetails(pokemonId);
    }
}
