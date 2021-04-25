package com.lasalle.sd2.g2.types.infrastructure.controller;

import com.lasalle.sd2.g2.types.infrastructure.conf.TypesConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpError;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

class PokemonTypesServletTest {

    private static final String CHARIZARD_TYPES = "{\"types\":[\"fire\",\"flying\"]}";
    private static final String POKEMON_INFO_NOT_FOUND = "{\"message\":\"Pokemon not found\"}";
    private static final String POKEAPI_ERROR = "{\"message\":\"Service unavailable\"}";

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
    void doGet() throws IOException {

        PokemonTypesServlet pokemonTypesServlet = new PokemonTypesServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getPathInfo()).thenReturn("/charizard");
        when(response.getWriter()).thenReturn(writer);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/charizard"), Times.exactly(1))
            .respond(response().withStatusCode(200)
                .withBody(new String(Files.readAllBytes(Paths.get("src/test/resources/charizard.json"))))
                .withDelay(TimeUnit.MICROSECONDS, 30));

        pokemonTypesServlet.doGet(request, response);

        assertEquals(CHARIZARD_TYPES, stringWriter.toString().trim());
    }

    @Test
    void doGetTimeout() throws IOException {
        PokemonTypesServlet pokemonTypesServlet = new PokemonTypesServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getPathInfo()).thenReturn("/charizard");
        when(response.getWriter()).thenReturn(writer);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/charizard"), Times.exactly(1))
            .error(HttpError.error().withDropConnection(Boolean.TRUE));

        pokemonTypesServlet.doGet(request, response);

        assertEquals(POKEMON_INFO_NOT_FOUND, stringWriter.toString().trim());
    }

    @Test
    void doGetPokeApiError() throws IOException {
        PokemonTypesServlet pokemonTypesServlet = new PokemonTypesServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getPathInfo()).thenReturn("/charizard");
        when(response.getWriter()).thenReturn(writer);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/charizard"), Times.exactly(1))
            .respond(response().withStatusCode(500)
                .withDelay(TimeUnit.MICROSECONDS, 30));

        pokemonTypesServlet.doGet(request, response);

        assertEquals(POKEAPI_ERROR, stringWriter.toString().trim());
    }

    @Test
    void doGetPokemonNotExists() throws IOException {
        PokemonTypesServlet pokemonTypesServlet = new PokemonTypesServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getPathInfo()).thenReturn("/nono");
        when(response.getWriter()).thenReturn(writer);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/nono"), Times.exactly(1))
            .respond(response().withStatusCode(404)
                .withBody("Not Found")
                .withDelay(TimeUnit.MICROSECONDS, 30));

        pokemonTypesServlet.doGet(request, response);

        assertEquals(POKEMON_INFO_NOT_FOUND, stringWriter.toString().trim());
    }
}
