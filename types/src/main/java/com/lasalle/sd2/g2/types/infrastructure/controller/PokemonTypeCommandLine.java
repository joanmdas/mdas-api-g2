package com.lasalle.sd2.g2.types.infrastructure.controller;

import com.lasalle.sd2.g2.types.application.ObtainPokemonTypes;
import com.lasalle.sd2.g2.types.application.dto.PokemonTypesResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.UndeclaredThrowableException;

public class PokemonTypeCommandLine {

    private static final Logger logger = LogManager.getLogger(PokemonTypeCommandLine.class);

    private final ObtainPokemonTypes obtainPokemonTypes;

    public PokemonTypeCommandLine(ObtainPokemonTypes obtainPokemonTypes) {
        this.obtainPokemonTypes = obtainPokemonTypes;
    }

    public void getPokemonTypes(String pokemonName) {
        try {
            PokemonTypesResponse pokemonTypes = obtainPokemonTypes.execute(pokemonName);

            logger.info("Found {} types", pokemonTypes.getTypes().size());
            logger.info("Type: {}", pokemonTypes.getTypes());
        }
        catch (UndeclaredThrowableException e) {
            logger.error(e.getUndeclaredThrowable().getMessage());
        }
    }
}
