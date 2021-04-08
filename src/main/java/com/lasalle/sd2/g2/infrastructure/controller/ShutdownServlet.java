package com.lasalle.sd2.g2.infrastructure.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;

import java.io.IOException;

public class ShutdownServlet extends HttpServlet {

    private static final long serialVersionUID = -8867382917784255585L;

    private static final Logger logger = LogManager.getLogger(ShutdownServlet.class);

    private final Server server;

    public ShutdownServlet(Server server) {
        this.server = server;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Stop the server.
            new Thread() {
                @Override
                public void run() {
                    try {
                        logger.info("Shutting down Jetty...");
                        server.stop();
                        logger.info("Jetty has stopped.");
                    } catch (Exception ex) {
                        logger.error("Error when stopping Jetty: {}", ex.getMessage());
                    }
                }
            }.start();
        } catch (Exception ex) {
            logger.error("Unable to stop Jetty: {}", ex);
        }
    }
}
