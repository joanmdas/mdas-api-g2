package com.lasalle.sd2.g2;

import com.lasalle.sd2.g2.application.ObtainPokemonTypes;
import com.lasalle.sd2.g2.domain.PokemonTypes;
import com.lasalle.sd2.g2.infrastructure.conf.AppProperties;
import com.lasalle.sd2.g2.infrastructure.repository.PokeApiRestCaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            AppProperties.loadAppProperties();
        } catch (IOException e) {
            logger.error("Error loading application properties");
        }

        PokeApiRestCaller pokeApiRestCaller = new PokeApiRestCaller();

        ObtainPokemonTypes obtainPokemonTypes = new ObtainPokemonTypes(pokeApiRestCaller);
        PokemonTypes pokemonTypes = obtainPokemonTypes.getPokemonTypes(args[0]);

        logger.info("Found {} types", pokemonTypes.getTypes().size());
        logger.info("Type: {}", pokemonTypes.getTypes());
    }
}
