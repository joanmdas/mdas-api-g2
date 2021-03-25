package com.lasalle.sd2.g2.infrastructure.repository;

import com.lasalle.sd2.g2.domain.PokemonRepository;
import com.lasalle.sd2.g2.domain.PokemonTypes;
import com.lasalle.sd2.g2.infrastructure.conf.AppProperties;
import com.lasalle.sd2.g2.infrastructure.dto.PokemonTypesDto;
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
            .target(PokeApiRepository.class, AppProperties.getBaseUrl());
    }

    @Override
    public PokemonTypes getPokemonTypes(String pokemonName) {
        PokemonTypesDto pokemonTypesDto = pokeApiRepository.getPokemonTypes(pokemonName);

        PokemonTypes pokemonTypes = new PokemonTypes();
        pokemonTypes.setTypes(pokemonTypesDto.getPokemonTypes());

        return pokemonTypes;
    }
}
