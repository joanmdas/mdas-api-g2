package com.lasalle.sd2.g2.types.infrastructure.repository;

import com.lasalle.sd2.g2.types.domain.PokemonName;
import com.lasalle.sd2.g2.types.domain.PokemonRepository;
import com.lasalle.sd2.g2.types.domain.PokemonTypes;
import com.lasalle.sd2.g2.types.infrastructure.conf.TypesConfiguration;
import com.lasalle.sd2.g2.types.infrastructure.repository.pokeapi.PokeApiTypesResponse;
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
            .options(new Request.Options(5, TimeUnit.SECONDS, 5, TimeUnit.SECONDS, false))
            .errorDecoder(new CustomErrorDecode())
            .target(PokeApiRepository.class, TypesConfiguration.getBaseUrl());
    }

    @Override
    public PokemonTypes getPokemonTypes(PokemonName name) {
        PokeApiTypesResponse pokeApiTypesResponse = pokeApiRepository.getPokemonTypes(name.getName());

        return new PokemonTypes(pokeApiTypesResponse.getPokemonTypes());
    }
}
