package com.lasalle.sd2.g2.infrastructure.server;

import com.lasalle.sd2.g2.infrastructure.conf.AppProperties;
import com.lasalle.sd2.g2.types.infrastructure.controller.PokemonTypesServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {

    private static final Logger logger = LogManager.getLogger(JettyServer.class);

    private final Server server = new Server();

    public JettyServer() {
        //Default constructor
    }

    public void start() throws Exception {

        try (ServerConnector connector = new ServerConnector(server)) {
            connector.setPort(Integer.parseInt(AppProperties.getServerPort()));
            server.setConnectors(new Connector[]{connector});

            ServletHandler servletHandler = new ServletHandler();
            server.setHandler(servletHandler);
            servletHandler.addServletWithMapping(PokemonTypesServlet.class, "/pokemonTypes/*");

            server.start();
            server.join();

            logger.info("Jetty server started at port {}", AppProperties.getServerPort());
        }
    }

}
