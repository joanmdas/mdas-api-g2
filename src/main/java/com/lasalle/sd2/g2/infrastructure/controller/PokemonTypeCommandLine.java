package com.lasalle.sd2.g2.infrastructure.controller;

import com.lasalle.sd2.g2.application.ObtainPokemonTypes;
import com.lasalle.sd2.g2.domain.PokemonTypes;
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
            PokemonTypes pokemonTypes = obtainPokemonTypes.getPokemonTypes(pokemonName);

            logger.info("Found {} types", pokemonTypes.getTypes().size());
            logger.info("Type: {}", pokemonTypes.getTypes());
        }
        catch (UndeclaredThrowableException e) {
            logger.error(e.getUndeclaredThrowable().getMessage());
        }
    }
}
