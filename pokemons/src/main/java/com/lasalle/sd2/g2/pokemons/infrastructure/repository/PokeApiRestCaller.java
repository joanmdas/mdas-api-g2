package com.lasalle.sd2.g2.pokemons.infrastructure.repository;

import com.lasalle.sd2.g2.pokemons.domain.PokemonDetails;
import com.lasalle.sd2.g2.pokemons.domain.PokemonId;
import com.lasalle.sd2.g2.pokemons.domain.PokemonRepository;
import com.lasalle.sd2.g2.pokemons.infrastructure.conf.PokemonsConfiguration;
import com.lasalle.sd2.g2.pokemons.infrastructure.dto.PokemonDetailsDto;
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
            .target(PokeApiRepository.class, PokemonsConfiguration.getBaseUrl());
    }

    @Override
    public PokemonDetails getPokemonDetails(PokemonId pokemonId) {
        PokemonDetailsDto pokemonDetailsDto = pokeApiRepository.getPokemonDetails(pokemonId.getId());

        return pokemonDetailsDto.getDetails();
    }
}
