package com.lasalle.sd2.g2.pokemons.application;

import com.lasalle.sd2.g2.pokemons.application.dto.PokemonDetailsResponse;
import com.lasalle.sd2.g2.pokemons.domain.PokemonDetails;
import com.lasalle.sd2.g2.pokemons.domain.PokemonId;
import com.lasalle.sd2.g2.pokemons.domain.PokemonRepository;

public class GetPokemonDetails {

    private final PokemonRepository repository;

    public GetPokemonDetails(PokemonRepository repository) {
        this.repository = repository;
    }

    public PokemonDetailsResponse execute(Integer id) {
        PokemonId pokemonId = new PokemonId(id);
        PokemonDetails pokemonDetails = repository.getPokemonDetails(pokemonId);
        return new PokemonDetailsResponse(pokemonDetails.getId(), pokemonDetails.getName(), pokemonDetails.getTypes());
    }
}
