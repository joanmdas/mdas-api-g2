package com.lasalle.sd2.g2.users.infrastructure.controller;

import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.infrastructure.repository.InMemoryUsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UsersFavoriteServletTest {

    private static final String USER_ID_HEADER = "user_id";
    private static final String ADD_FAV_POKEMON_REQ_JSON = "{\n" +
        "    \"pokemonId\": 123\n" +
        "}";
    private static final String USER_UUID_NOT_EXISTS_STRING = "797e7ac7-2873-4136-9719-8d112b7f3a25";
    private static final String USER_NOT_FOUND_RESP_BODY = "{\"message\":\"User " + USER_UUID_NOT_EXISTS_STRING + " not found\"}";

    private static String userUUIDExistsString;

    @BeforeAll
    static void beforeAll() {
        InMemoryUsersRepository repository = new InMemoryUsersRepository();
        User user = User.create();
        repository.save(user);
        userUUIDExistsString = user.getUserId().toString();
    }

    @Test
    void doPostAddedFavoritePokemon() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        Reader reader = new StringReader(ADD_FAV_POKEMON_REQ_JSON);
        BufferedReader bufferedReader = new BufferedReader(reader);

        when(request.getHeader(USER_ID_HEADER)).thenReturn(userUUIDExistsString);
        when(request.getReader()).thenReturn(bufferedReader);

        UsersFavoriteServlet usersFavoriteServlet = new UsersFavoriteServlet();
        usersFavoriteServlet.doPost(request, response);

        assertTrue(true);
    }

    @Test
    void doPostUserNotExists() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        Reader reader = new StringReader(ADD_FAV_POKEMON_REQ_JSON);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getHeader(USER_ID_HEADER)).thenReturn(USER_UUID_NOT_EXISTS_STRING);
        when(request.getReader()).thenReturn(bufferedReader);
        when(response.getWriter()).thenReturn(writer);

        UsersFavoriteServlet usersFavoriteServlet = new UsersFavoriteServlet();
        usersFavoriteServlet.doPost(request, response);

        assertEquals(USER_NOT_FOUND_RESP_BODY, stringWriter.toString().trim());
    }
}
