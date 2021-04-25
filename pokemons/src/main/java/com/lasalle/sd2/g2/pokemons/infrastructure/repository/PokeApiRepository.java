package com.lasalle.sd2.g2.pokemons.infrastructure.repository;

import com.lasalle.sd2.g2.pokemons.infrastructure.repository.pokeapi.PokeApiDetailsResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PokeApiRepository {

    @RequestLine("GET /pokemon/{pokemonId}")
    @Headers("Content-Type: application/json")
    PokeApiDetailsResponse getPokemonDetails(@Param("pokemonId") Integer pokemonId);

}
