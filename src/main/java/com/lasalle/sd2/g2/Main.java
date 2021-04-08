package com.lasalle.sd2.g2;

import com.lasalle.sd2.g2.application.ObtainPokemonTypes;
import com.lasalle.sd2.g2.infrastructure.conf.AppProperties;
import com.lasalle.sd2.g2.infrastructure.controller.PokemonTypeCommandLine;
import com.lasalle.sd2.g2.infrastructure.controller.ShutdownServlet;
import com.lasalle.sd2.g2.infrastructure.repository.PokeApiRestCaller;
import com.lasalle.sd2.g2.infrastructure.server.JettyServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;

import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        try {
            AppProperties.loadAppProperties();
        } catch (IOException e) {
            logger.error("Error loading application properties");
        }

        if ("server".equals(args[0])) {
            Server server = new Server();

            ShutdownServlet shutdownServlet = new ShutdownServlet(server);

            JettyServer jettyServer = new JettyServer(server);
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
