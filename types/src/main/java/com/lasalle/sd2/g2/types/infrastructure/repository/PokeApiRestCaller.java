package com.lasalle.sd2.g2.types.infrastructure.repository;

import com.lasalle.sd2.g2.types.domain.PokemonRepository;
import com.lasalle.sd2.g2.types.domain.PokemonTypes;
import com.lasalle.sd2.g2.types.infrastructure.conf.TypesConfiguration;
import com.lasalle.sd2.g2.types.infrastructure.dto.PokemonTypesDto;
import feign.Feign;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.concurrent.TimeUnit;

public class PokeApiRestCaller implements PokemonRepository {

    private final PokeApiRepository pokeApiRepository;

    public PokeApiRestCaller() {
        pokeApiRepository = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .options(new Request.Options(10, TimeUnit.SECONDS, 30, TimeUnit.SECONDS, false))
            .errorDecoder(new CustomErrorDecode())
            .target(PokeApiRepository.class, TypesConfiguration.getBaseUrl());
    }

    @Override
    public PokemonTypes getPokemonTypes(String pokemonName) {
        PokemonTypesDto pokemonTypesDto = pokeApiRepository.getPokemonTypes(pokemonName);

        return new PokemonTypes(pokemonTypesDto.getPokemonTypes());
    }
}