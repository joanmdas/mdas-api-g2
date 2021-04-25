package com.lasalle.sd2.g2.types.infrastructure.controller;

import com.lasalle.sd2.g2.types.application.ObtainPokemonTypes;
import com.lasalle.sd2.g2.types.domain.PokemonRepository;
import com.lasalle.sd2.g2.types.infrastructure.conf.TypesConfiguration;
import com.lasalle.sd2.g2.types.infrastructure.repository.PokeApiRestCaller;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

class PokemonTypeCommandLineTest {

    private static ClientAndServer mockServer;

    @BeforeAll
    static void beforeAll() {
        mockServer = ClientAndServer.startClientAndServer();
        TypesConfiguration.setBaseUrl("http://localhost:" + mockServer.getLocalPort());
    }

    @AfterAll
    static void afterAll() {
        mockServer.stop();
    }

    @Test
    void getPokemonTypes() throws IOException {
        PokemonRepository repository = new PokeApiRestCaller();
        ObtainPokemonTypes obtainPokemonTypes = new ObtainPokemonTypes(repository);
        PokemonTypeCommandLine pokemonTypeCommandLine = new PokemonTypeCommandLine(obtainPokemonTypes);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/charizard"), Times.exactly(1))
            .respond(response().withStatusCode(200)
                .withBody(new String(Files.readAllBytes(Paths.get("src/test/resources/charizard.json"))))
                .withDelay(TimeUnit.MICROSECONDS, 30));

        pokemonTypeCommandLine.getPokemonTypes("charizard");

        assertTrue(true);
    }
}
