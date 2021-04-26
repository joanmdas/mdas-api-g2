package com.lasalle.sd2.g2.pokemons.infrastructure.controller;

import com.lasalle.sd2.g2.pokemons.infrastructure.conf.PokemonsConfiguration;
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
import static org.mockito.Mockito.*;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

class PokemonInfoServletTest {

    private static final String ID_15_POKEMON_INFO = "{\"id\":15,\"name\":\"beedrill\",\"types\":[\"bug\",\"poison\"]}";
    private static final String POKEMON_INFO_NOT_FOUND = "{\"message\":\"Pokemon not found\"}";
    private static final String POKEAPI_ERROR = "{\"message\":\"Service unavailable\"}";

    private static ClientAndServer mockServer;

    @BeforeAll
    static void beforeAll() {
        mockServer = ClientAndServer.startClientAndServer();
        PokemonsConfiguration.setBaseUrl("http://localhost:" + mockServer.getLocalPort());
    }

    @AfterAll
    static void afterAll() {
        mockServer.stop();
    }

    @Test
    void doGetOK() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getPathInfo()).thenReturn("/15");
        when(response.getWriter()).thenReturn(writer);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/15"), Times.exactly(1))
            .respond(response().withStatusCode(200)
                .withBody(new String(Files.readAllBytes(Paths.get("src/test/resources/beedrill.json"))))
                .withDelay(TimeUnit.MICROSECONDS, 30));

        PokemonInfoServlet pokemonInfoServlet = new PokemonInfoServlet();
        pokemonInfoServlet.doGet(request, response);

        assertEquals(ID_15_POKEMON_INFO, stringWriter.toString().trim());
    }

    @Test
    void doGetTimeout() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getPathInfo()).thenReturn("/15");
        when(response.getWriter()).thenReturn(writer);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/15"), Times.exactly(1))
            .error(HttpError.error().withDropConnection(Boolean.TRUE));

        PokemonInfoServlet pokemonInfoServlet = new PokemonInfoServlet();
        pokemonInfoServlet.doGet(request, response);

        assertEquals(POKEMON_INFO_NOT_FOUND, stringWriter.toString().trim());
    }

    @Test
    void doGetPokeApiError() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getPathInfo()).thenReturn("/15");
        when(response.getWriter()).thenReturn(writer);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/15"), Times.exactly(1))
            .respond(response().withStatusCode(500)
                .withDelay(TimeUnit.MICROSECONDS, 30));

        PokemonInfoServlet pokemonInfoServlet = new PokemonInfoServlet();
        pokemonInfoServlet.doGet(request, response);

        assertEquals(POKEAPI_ERROR, stringWriter.toString().trim());
    }

    @Test
    void doGetPokemonNotExists() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getPathInfo()).thenReturn("/999");
        when(response.getWriter()).thenReturn(writer);

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/999"), Times.exactly(1))
            .respond(response().withStatusCode(404)
                .withBody("Not Found")
                .withDelay(TimeUnit.MICROSECONDS, 30));

        PokemonInfoServlet pokemonInfoServlet = new PokemonInfoServlet();
        pokemonInfoServlet.doGet(request, response);

        assertEquals(POKEMON_INFO_NOT_FOUND, stringWriter.toString().trim());
    }
}
