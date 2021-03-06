package com.lasalle.sd2.g2.types.infrastructure.controller;

import com.google.gson.Gson;
import com.lasalle.sd2.g2.types.application.ObtainPokemonTypes;
import com.lasalle.sd2.g2.types.application.dto.PokemonTypesResponse;
import com.lasalle.sd2.g2.types.application.dto.ErrorMessageDto;
import com.lasalle.sd2.g2.types.infrastructure.repository.PokeApiRestCaller;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

public class PokemonTypesServlet extends HttpServlet {

    private static final long serialVersionUID = -6810690091868968761L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Obtain pokemon from url
        String pathInfo = req.getPathInfo();

        PokeApiRestCaller pokeApiRestCaller = new PokeApiRestCaller();
        ObtainPokemonTypes obtainPokemonTypes = new ObtainPokemonTypes(pokeApiRestCaller);

        PokemonTypesResponse pokemonTypesResponse;
        try {
            pokemonTypesResponse = obtainPokemonTypes.execute(pathInfo.split("/")[1]);
            resp.getWriter().println(new Gson().toJson(pokemonTypesResponse));
            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        catch (UndeclaredThrowableException e) {
            ErrorMessageDto errorMessageDto = new ErrorMessageDto(e.getUndeclaredThrowable().getMessage());
            resp.getWriter().println(new Gson().toJson(errorMessageDto));
            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
