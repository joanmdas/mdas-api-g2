package com.lasalle.sd2.g2.types.infrastructure.server;

import com.lasalle.sd2.g2.types.infrastructure.repository.CustomErrorDecode;
import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomErrorDecodeTest {

    private static final String METHOD_KEY = "PokeApiRepository#getPokemonTypes(String)";
    private static final Request REQUEST = Request.create(Request.HttpMethod.GET, "https://pokeapi.co/api/v2",
        new HashMap<>(), Request.Body.create("Pikachu"), new RequestTemplate());
    private static final Response RESPONSE_404 = Response.builder()
        .status(404)
        .reason("Not Found")
        .request(REQUEST)
        .build();
    private static final Response RESPONSE_502 = Response.builder()
        .status(502)
        .reason("Bad Gateway")
        .request(REQUEST)
        .build();

    @Test
    void decode404() {
        CustomErrorDecode customErrorDecode = new CustomErrorDecode();
        Exception decode = customErrorDecode.decode(METHOD_KEY, RESPONSE_404);

        assertNotNull(decode);
        assertEquals("Pokemon not found", decode.getMessage());
    }

    @Test
    void decodeDefault() {
        CustomErrorDecode customErrorDecode = new CustomErrorDecode();
        Exception decode = customErrorDecode.decode(METHOD_KEY, RESPONSE_502);

        assertNotNull(decode);
        assertEquals("Service unavailable", decode.getMessage());
    }
}
