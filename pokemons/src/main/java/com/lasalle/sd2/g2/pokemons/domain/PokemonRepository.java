package com.lasalle.sd2.g2.pokemons.domain;

public interface PokemonRepository {

    PokemonDetails getPokemonDetails(PokemonId pokemonId);
}
