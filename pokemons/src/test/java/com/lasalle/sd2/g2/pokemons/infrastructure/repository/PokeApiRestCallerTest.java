package com.lasalle.sd2.g2.pokemons.infrastructure.repository;

import com.lasalle.sd2.g2.pokemons.domain.PokemonDetails;
import com.lasalle.sd2.g2.pokemons.domain.PokemonId;
import com.lasalle.sd2.g2.pokemons.infrastructure.conf.PokemonsConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpError;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

class PokeApiRestCallerTest {

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
    void getPokemonDetailsExists() throws IOException {
        // Given
        List<String> pokemonTypesList = new ArrayList<>();
        pokemonTypesList.add("bug");
        pokemonTypesList.add("poison");

        PokemonDetails pokemonTypesExpected = new PokemonDetails(15, "beedrill", pokemonTypesList);
        PokeApiRestCaller restCaller = new PokeApiRestCaller();

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/15"), Times.exactly(1))
            .respond(response().withStatusCode(200)
                .withBody(new String(Files.readAllBytes(Paths.get("src/test/resources/beedrill.json"))))
                .withDelay(TimeUnit.MICROSECONDS, 30));

        // When
        PokemonDetails beeDrillDetails = restCaller.getPokemonDetails(new PokemonId(15));

        // Then
        assertNotNull(beeDrillDetails);
        assertEquals(pokemonTypesExpected, beeDrillDetails);
    }

    @Test
    void timeout() {
        // Given
        PokeApiRestCaller restCaller = new PokeApiRestCaller();

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/15"), Times.exactly(1))
            .error(HttpError.error().withDropConnection(Boolean.TRUE));

        PokemonId pokemonId = new PokemonId(15);

        // Then
        UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> restCaller.getPokemonDetails(pokemonId));
        assertEquals("Pokemon not found", exception.getUndeclaredThrowable().getMessage());
    }

    @Test
    void getPokemonNotExist() {
        // Given
        PokeApiRestCaller restCaller = new PokeApiRestCaller();

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/999"), Times.exactly(1))
            .respond(response().withStatusCode(404).withDelay(TimeUnit.MICROSECONDS, 30));

        PokemonId pokemonId = new PokemonId(999);

        // Then
        UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> restCaller.getPokemonDetails(pokemonId));
        assertEquals("Pokemon not found", exception.getUndeclaredThrowable().getMessage());
    }
}
