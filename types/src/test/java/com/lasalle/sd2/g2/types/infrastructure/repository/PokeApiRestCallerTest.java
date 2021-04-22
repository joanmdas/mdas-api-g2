package com.lasalle.sd2.g2.types.infrastructure.repository;

import com.lasalle.sd2.g2.types.domain.PokemonTypes;
import com.lasalle.sd2.g2.types.infrastructure.conf.TypesConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;

import java.lang.reflect.UndeclaredThrowableException;
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
        TypesConfiguration.setBaseUrl("http://localhost:" + mockServer.getLocalPort());
    }

    @AfterAll
    static void afterAll() {
        mockServer.stop();
    }

    @Test
    void getPokemonTypesExists() {
        // Given
        List<String> pokemonTypesList = new ArrayList<>();
        pokemonTypesList.add("fires");
        pokemonTypesList.add("flying");

        PokemonTypes pokemonTypesExpected = new PokemonTypes(pokemonTypesList);
        PokeApiRestCaller restCaller = new PokeApiRestCaller();

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/charizard"), Times.exactly(1))
            .respond(response().withStatusCode(200).withBody("{  \"types\": [\n" +
                "    {\n" +
                "      \"slot\": 1,\n" +
                "      \"type\": {\n" +
                "        \"name\": \"fires\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/type/10/\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"slot\": 2,\n" +
                "      \"type\": {\n" +
                "        \"name\": \"flying\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/type/3/\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]}").withDelay(TimeUnit.MICROSECONDS, 30));

        // When
        PokemonTypes charizardTypes = restCaller.getPokemonTypes("charizard");

        // Then
        assertNotNull(charizardTypes);
        assertEquals(pokemonTypesExpected, charizardTypes);
    }

    @Test
    void timeout() {
        // Given
        PokeApiRestCaller restCaller = new PokeApiRestCaller();

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/charizard"), Times.exactly(1))
            .respond(response().withDelay(TimeUnit.DAYS, 36));

        // Then
        UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> restCaller.getPokemonTypes("charizard"));
        assertEquals("Pokemon not found", exception.getUndeclaredThrowable().getMessage());
    }

    @Test
    void getPokemonNotExist() {
        // Given
        PokeApiRestCaller restCaller = new PokeApiRestCaller();

        new MockServerClient("localhost", mockServer.getLocalPort())
            .when(request().withMethod("GET").withPath("/pokemon/charizard"), Times.exactly(1))
            .respond(response().withStatusCode(404).withDelay(TimeUnit.MICROSECONDS, 30));

        // Then
        UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> restCaller.getPokemonTypes("charizardPicachu"));
        assertEquals("Pokemon not found", exception.getUndeclaredThrowable().getMessage());
    }
}
