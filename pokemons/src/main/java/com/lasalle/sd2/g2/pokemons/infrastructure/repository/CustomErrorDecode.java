package com.lasalle.sd2.g2.pokemons.infrastructure.repository;

import com.lasalle.sd2.g2.pokemons.domain.PokemonDetailsException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomErrorDecode implements ErrorDecoder {

    private static final Logger logger = LogManager.getLogger(CustomErrorDecode.class);

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() != 404) {
            logger.error("Unexpected error: {}", response.reason());
            return new PokemonDetailsException("Service unavailable");
        }
        return new PokemonDetailsException("Pokemon not found");
    }
}
