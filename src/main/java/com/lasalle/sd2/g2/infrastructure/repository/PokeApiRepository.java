package com.lasalle.sd2.g2.infrastructure.repository;

import com.lasalle.sd2.g2.infrastructure.dto.PokemonTypesDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PokeApiRepository {

    @RequestLine("GET /pokemon/{pokemonName}")
    @Headers("Content-Type: application/json")
    PokemonTypesDto getPokemonTypes(@Param("pokemonName") String pokemonName);

}
