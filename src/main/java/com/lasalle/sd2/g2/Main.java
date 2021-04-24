package com.lasalle.sd2.g2;

import com.lasalle.sd2.g2.types.application.ObtainPokemonTypes;
import com.lasalle.sd2.g2.types.infrastructure.controller.PokemonTypeCommandLine;
import com.lasalle.sd2.g2.types.infrastructure.repository.PokeApiRestCaller;
import com.lasalle.sd2.g2.infrastructure.conf.AppProperties;
import com.lasalle.sd2.g2.infrastructure.server.JettyServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        try {
            AppProperties.loadAppProperties();
            AppProperties.sendPropertiesToTypes();
            AppProperties.sendPropertiesToPokemons();
        } catch (IOException e) {
            logger.error("Error loading application properties");
        }


        if ("server".equals(args[0])) {
            JettyServer jettyServer = new JettyServer();
            jettyServer.start();
        }
        else {
            PokeApiRestCaller pokeApiRestCaller = new PokeApiRestCaller();
            ObtainPokemonTypes obtainPokemonTypes = new ObtainPokemonTypes(pokeApiRestCaller);

            PokemonTypeCommandLine pokemonTypeCommandLine = new PokemonTypeCommandLine(obtainPokemonTypes);
            pokemonTypeCommandLine.getPokemonTypes(args[0]);
        }
    }
}
