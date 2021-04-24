package com.lasalle.sd2.g2.pokemons.infrastructure.controller;

import com.google.gson.Gson;
import com.lasalle.sd2.g2.pokemons.application.GetPokemonDetails;
import com.lasalle.sd2.g2.pokemons.domain.PokemonDetails;
import com.lasalle.sd2.g2.pokemons.domain.PokemonId;
import com.lasalle.sd2.g2.pokemons.infrastructure.dto.ErrorMessageDto;
import com.lasalle.sd2.g2.pokemons.infrastructure.repository.PokeApiRestCaller;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

public class PokemonInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1574430068088429407L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Obtain pokemon id from url
        String pathInfo = req.getPathInfo();
        PokemonId pokemonId = new PokemonId(Integer.valueOf(pathInfo.split("/")[1]));

        PokeApiRestCaller pokeApiRestCaller = new PokeApiRestCaller();
        GetPokemonDetails getPokemonDetails = new GetPokemonDetails(pokeApiRestCaller);

        PokemonDetails pokemonDetails;

        try {
            pokemonDetails = getPokemonDetails.execute(pokemonId);
            resp.getWriter().println(new Gson().toJson(pokemonDetails));
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
